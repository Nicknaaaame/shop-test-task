package purchase.portlet.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import purchase.portlet.constants.PurchasePortletKeys;
import purchase.portlet.mapper.PurchaseModelMapper;
import shop.model.Purchase;
import shop.service.PurchaseLocalServiceUtil;

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
	public void addPurchase(ActionRequest request, ActionResponse response) throws SystemException {
		long id = CounterLocalServiceUtil.increment();
		Purchase purchase = PurchaseLocalServiceUtil.createPurchase(id);
		PurchaseModelMapper.map(request, purchase);
		PurchaseLocalServiceUtil.addPurchase(purchase);
	}

	public void updatePurchase(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		long id = ParamUtil.getLong(request, "id");
		Purchase purchase = PurchaseLocalServiceUtil.getPurchase(id);
		PurchaseModelMapper.map(request, purchase);
		PurchaseLocalServiceUtil.updatePurchase(purchase);
	}

	public void deletePurchase(ActionRequest request, ActionResponse response) throws PortalException {
		long id = ParamUtil.getLong(request, "id");
		PurchaseLocalServiceUtil.deletePurchase(id);
	}
}