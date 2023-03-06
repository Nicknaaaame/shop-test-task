package electro.portlet.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import electro.portlet.constants.ElectroPortletKeys;
import electro.portlet.mapper.ElectronicsModelMapper;
import org.osgi.service.component.annotations.Component;
import shop.model.Electronics;
import shop.service.ElectronicsLocalServiceUtil;
import shop.service.EmployeeLocalServiceUtil;
import util.ShopProjectUtil;

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
		"javax.portlet.display-name=Electro",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ElectroPortletKeys.ELECTRONICS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ElectronicsPortlet extends MVCPortlet {
	public void addElectronics(ActionRequest request, ActionResponse response) throws SystemException {
		long id = CounterLocalServiceUtil.increment();
		Electronics electronics = ElectronicsLocalServiceUtil.createElectronics(id);
		ElectronicsModelMapper.map(request, electronics);
		ElectronicsLocalServiceUtil.addElectronics(electronics);
	}

	public void updateElectronics(ActionRequest request, ActionResponse response) throws SystemException {
		long id = ParamUtil.getLong(request, "id");
		try {
			Electronics electronics = ElectronicsLocalServiceUtil.getElectronics(id);
			ElectronicsModelMapper.map(request, electronics);
			ElectronicsLocalServiceUtil.updateElectronics(electronics);
		} catch (PortalException e) {
			ShopProjectUtil.handleException(request, response, e);
		}
	}

	public void deleteElectronics(ActionRequest request, ActionResponse response) {
		long id = ParamUtil.getLong(request, "id");
		try {
			EmployeeLocalServiceUtil.deleteEmployee(id);
		} catch (PortalException e) {
			ShopProjectUtil.handleException(request, response, e);
		}
	}
}