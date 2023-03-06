package employee.portlet.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import employee.portlet.constants.EmployeePortletKeys;
import employee.portlet.mapper.EmployeeModelMapper;
import org.osgi.service.component.annotations.Component;
import shop.model.Employee;
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
                "javax.portlet.display-name=Employee",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + EmployeePortletKeys.EMPLOYEE,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class EmployeePortlet extends MVCPortlet {
    public void addEmployee(ActionRequest request, ActionResponse response) throws SystemException {
        long id = CounterLocalServiceUtil.increment();
        Employee employee = EmployeeLocalServiceUtil.createEmployee(id);
        EmployeeModelMapper.map(request, employee);
        EmployeeLocalServiceUtil.addEmployee(employee);
    }

    public void updateEmployee(ActionRequest request, ActionResponse response) throws SystemException {
        long id = ParamUtil.getLong(request, "id");
        try {
            Employee employee = EmployeeLocalServiceUtil.getEmployee(id);
            EmployeeModelMapper.map(request, employee);
            EmployeeLocalServiceUtil.updateEmployee(employee);
        } catch (PortalException e) {
            ShopProjectUtil.handleException(request, response, e);
        }
    }

    public void deleteEmployee(ActionRequest request, ActionResponse response) {
        long id = ParamUtil.getLong(request, "id");
        try {
            EmployeeLocalServiceUtil.deleteEmployee(id);
        } catch (PortalException e) {
            ShopProjectUtil.handleException(request, response, e);
        }
    }
}