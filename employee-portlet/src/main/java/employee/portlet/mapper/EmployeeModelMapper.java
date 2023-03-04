package employee.portlet.mapper;

import com.liferay.portal.kernel.util.ParamUtil;
import shop.model.Employee;
import util.ShopProjectUtil;

import javax.portlet.ActionRequest;
import java.util.Date;

public class EmployeeModelMapper {
    public static void map(ActionRequest request, Employee employee) {
        String lastName = ParamUtil.getString(request, "lastName");
        String firstName = ParamUtil.getString(request, "firstName");
        String patronymic = ParamUtil.getString(request, "patronymic");
        boolean gender = Boolean.parseBoolean(ParamUtil.getString(request, "gender"));
        Date birthDate = ShopProjectUtil.parseDateFromRequest(ParamUtil.getString(request, "birthDate"));
        long positionId = ParamUtil.getLong(request, "positionId");

        employee.setLastName(lastName);
        employee.setFirstName(firstName);
        employee.setPatronymic(patronymic);
        employee.setGender(gender);
        employee.setBirthDate(birthDate);
        employee.setPositionId(positionId);
    }
}
