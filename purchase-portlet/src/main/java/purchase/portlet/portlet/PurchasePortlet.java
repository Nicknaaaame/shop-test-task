package purchase.portlet.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import purchase.portlet.constants.PurchasePortletKeys;
import purchase.portlet.mapper.PurchaseModelMapper;
import shop.exception.NoSuchElectroTypeException;
import shop.exception.NoSuchElectronicsException;
import shop.exception.NoSuchEmployeeException;
import shop.model.Electronics;
import shop.model.Purchase;
import shop.service.*;
import shop.service.persistence.ElectroEmployeePK;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

/**
 * @author dlyar
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Purchase",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + PurchasePortletKeys.PURCHASE,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class PurchasePortlet extends MVCPortlet {
    public void addPurchase(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
        long id = CounterLocalServiceUtil.increment();
        Purchase purchase = PurchaseLocalServiceUtil.createPurchase(id);
        PurchaseModelMapper.map(request, purchase);
        if (checkIfEmployeeHasNoEType(purchase)) {
            SessionErrors.add(request, PurchasePortletKeys.EMPLOYEE_HAS_NO_ETYPE);
            return;
        }
        Electronics product = ElectronicsLocalServiceUtil.getElectronics(purchase.getElectroId());
        if (checkIfProductIsNotInStock(product)) {
            SessionErrors.add(request, PurchasePortletKeys.PRODUCT_IS_NOT_IN_STOCK);
            return;
        }
        checkForeignKeys(request, response, purchase);
        product.setCount(product.getCount() - 1);
        ElectronicsLocalServiceUtil.updateElectronics(product);
        PurchaseLocalServiceUtil.addPurchase(purchase);
    }

    public void updatePurchase(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
        long id = ParamUtil.getLong(request, "id");
        Purchase purchase = PurchaseLocalServiceUtil.getPurchase(id);
        long electroIdTmp = purchase.getElectroId();
        PurchaseModelMapper.map(request, purchase);
        purchase.setElectroId(electroIdTmp);
        if (checkIfEmployeeHasNoEType(purchase)) {
            SessionErrors.add(request, PurchasePortletKeys.EMPLOYEE_HAS_NO_ETYPE);
            return;
        }
        PurchaseLocalServiceUtil.updatePurchase(purchase);
    }

    public void deletePurchase(ActionRequest request, ActionResponse response) throws PortalException {
        long id = ParamUtil.getLong(request, "id");
        PurchaseLocalServiceUtil.deletePurchase(id);
    }

    private void checkForeignKeys(ActionRequest request, ActionResponse response, Purchase purchase)
            throws NoSuchElectronicsException, NoSuchEmployeeException, NoSuchElectroTypeException {
        if (ElectronicsLocalServiceUtil.fetchElectronics(purchase.getElectroId()) == null) {
            String message = String.format("Product with id: %d does not exist", purchase.getElectroId());
            response.setRenderParameter(PurchasePortletKeys.EXCEPTION_MESSAGE, message);
            SessionErrors.add(request, NoSuchElectronicsException.class);
            throw new NoSuchElectronicsException(message);
        }

        if (EmployeeLocalServiceUtil.fetchEmployee(purchase.getEmployeeId()) == null) {
            String message = String.format("Employee with id: %d does not exist", purchase.getEmployeeId());
            response.setRenderParameter(PurchasePortletKeys.EXCEPTION_MESSAGE, message);
            SessionErrors.add(request, NoSuchEmployeeException.class);
            throw new NoSuchEmployeeException(message);
        }

        if (ElectroTypeLocalServiceUtil.fetchElectroType(purchase.getETypeId()) == null) {
            String message = String.format("Electro type with id: %d does not exist", purchase.getETypeId());
            response.setRenderParameter(PurchasePortletKeys.EXCEPTION_MESSAGE, message);
            SessionErrors.add(request, NoSuchElectroTypeException.class);
            throw new NoSuchElectroTypeException(message);
        }
    }

    private boolean checkIfEmployeeHasNoEType(Purchase purchase) {
        long employeeId = purchase.getEmployeeId();
        long eTypeId = purchase.getETypeId();
        try {
            ElectroEmployeeLocalServiceUtil.getElectroEmployee(new ElectroEmployeePK(employeeId, eTypeId));
        } catch (PortalException e) {
            return true;
        }
        return false;
    }

    private boolean checkIfProductIsNotInStock(Electronics product) {
        return product.getCount() <= 0 || product.getIsArchive() || !product.getIsInStock();
    }
}