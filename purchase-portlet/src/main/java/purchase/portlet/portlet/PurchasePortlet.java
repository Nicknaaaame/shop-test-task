package purchase.portlet.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import purchase.portlet.constants.PurchasePortletKeys;
import purchase.portlet.mapper.PurchaseModelMapper;
import shop.exception.ElectronicsIsNotInStockException;
import shop.exception.NoSuchElectroEmployeeException;
import shop.model.Electronics;
import shop.model.Purchase;
import shop.service.*;
import shop.service.persistence.ElectroEmployeePK;
import util.ShopProjectUtil;

import javax.portlet.*;
import java.io.IOException;

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
    public void addPurchase(ActionRequest request, ActionResponse response) throws SystemException {
        long id = CounterLocalServiceUtil.increment();
        Purchase purchase = PurchaseLocalServiceUtil.createPurchase(id);
        PurchaseModelMapper.map(request, purchase);
        try {
            ShopProjectUtil.validateDate(purchase.getPurchaseDate());
            Electronics product = ElectronicsLocalServiceUtil.getElectronics(purchase.getElectroId());
            checkProductInStock(product);
            checkEmployeeHasEType(purchase);
            checkForeignKeys(purchase);
            product.setCount(product.getCount() - 1);
            ElectronicsLocalServiceUtil.updateElectronics(product);
            PurchaseLocalServiceUtil.addPurchase(purchase);
        } catch (ElectronicsIsNotInStockException | PortalException e) {
            ShopProjectUtil.handleException(request, response, e);
        }
    }

    public void updatePurchase(ActionRequest request, ActionResponse response) throws SystemException {
        long id = ParamUtil.getLong(request, "id");
        try {
            Purchase purchase = PurchaseLocalServiceUtil.getPurchase(id);
            long electroIdTmp = purchase.getElectroId();
            PurchaseModelMapper.map(request, purchase);
            purchase.setElectroId(electroIdTmp);
            ShopProjectUtil.validateDate(purchase.getPurchaseDate());
            checkEmployeeHasEType(purchase);
            checkForeignKeys(purchase);
            PurchaseLocalServiceUtil.updatePurchase(purchase);
        } catch (PortalException e) {
            ShopProjectUtil.handleException(request, response, e);
        }
    }

    public void deletePurchase(ActionRequest request, ActionResponse response) {
        long id = ParamUtil.getLong(request, "id");
        try {
            PurchaseLocalServiceUtil.deletePurchase(id);
        } catch (PortalException e) {
            ShopProjectUtil.handleException(request, response, e);
        }
    }

    private void checkForeignKeys(Purchase purchase) throws PortalException {
        ElectronicsLocalServiceUtil.getElectronics(purchase.getElectroId());
        EmployeeLocalServiceUtil.getEmployee(purchase.getEmployeeId());
        PurchaseTypeLocalServiceUtil.getPurchaseType(purchase.getType());
    }

    private void checkEmployeeHasEType(Purchase purchase) throws PortalException {
        long eTypeId = ElectronicsLocalServiceUtil.getElectronics(purchase.getElectroId()).getETypeId();
        ElectroEmployeePK electroEmployeePK = new ElectroEmployeePK(purchase.getEmployeeId(), eTypeId);
        if (ElectroEmployeeLocalServiceUtil.fetchElectroEmployee(electroEmployeePK) == null)
            throw new NoSuchElectroEmployeeException(electroEmployeePK);
    }

    private void checkProductInStock(Electronics product) throws ElectronicsIsNotInStockException {
        if (product.getCount() <= 0 || product.getIsArchive() || !product.getIsInStock())
            throw new ElectronicsIsNotInStockException(product.getId());
    }
}