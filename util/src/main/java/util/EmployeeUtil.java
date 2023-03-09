package util;

import shop.model.Employee;

import java.util.List;
import java.util.StringJoiner;

public class EmployeeUtil {
    public static String getFio(Employee employee) {
        return String.format("%s %s %s", employee.getLastName(), employee.getFirstName(), employee.getPatronymic());
    }

    public static String getFio(List<Employee> employees) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (Employee employee : employees)
            stringJoiner.add(getFio(employee));
        return stringJoiner.toString();
    }
}
