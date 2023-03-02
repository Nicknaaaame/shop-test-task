package com.lapotko.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import shop.model.Employee;
import shop.service.EmployeeLocalServiceUtil;

import java.sql.Date;
import java.util.HashMap;

public class EmployeeCsvImporter extends BaseCsvImporterImpl<Employee> {
    public EmployeeCsvImporter() {
        columnSetterMap = new HashMap<>();
        columnSetterMap.put("id", (employee, s) -> {
            employee.setId(Long.parseLong(s));
        });
        columnSetterMap.put("lastname", (employee, s) -> {
            employee.setLastName(s);
        });
        columnSetterMap.put("firstname", (employee, s) -> {
            employee.setFirstName(s);
        });
        columnSetterMap.put("patronymic", (employee, s) -> {
            employee.setPatronymic(s);
        });
        columnSetterMap.put("birthdate", (employee, s) -> {
            employee.setBirthDate(Date.valueOf(s));
        });
        columnSetterMap.put("gender", (employee, s) -> {
            employee.setGender(Boolean.parseBoolean(s));
        });
        columnSetterMap.put("positionid", (employee, s) -> {
            employee.setPositionId(Long.parseLong(s));
        });
    }

    @Override
    protected Employee createModel() {
        return EmployeeLocalServiceUtil.createEmployee(CounterLocalServiceUtil.increment());
    }

    @Override
    protected void saveModel(Employee model) {
        EmployeeLocalServiceUtil.addEmployee(model);
    }
}