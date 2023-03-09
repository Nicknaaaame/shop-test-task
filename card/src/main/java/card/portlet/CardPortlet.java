package card.portlet;

import card.constants.CardPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import shop.model.Employee;
import shop.service.EmployeeLocalServiceUtil;
import shop.service.PositionTypeLocalServiceUtil;
import util.ShopProjectUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import java.util.List;

/**
 * @author dlyar
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Card",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + CardPortletKeys.CARD,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class CardPortlet extends MVCPortlet {
    public void viewTopEmployee(ActionRequest request, ActionResponse response) {
        long positionId = ParamUtil.getLong(request, "positionId");
        try {
			checkIfPositionExist(positionId);
            List<Employee> employees = EmployeeLocalServiceUtil.getTopEmployeeByPositionId(positionId);
            request.setAttribute("employees", employees);
        } catch (Exception e) {
            ShopProjectUtil.handleException(request, response, e);
        }
    }

    private void checkIfPositionExist(long positionId) throws PortalException {
        PositionTypeLocalServiceUtil.getPositionType(positionId);
    }
}