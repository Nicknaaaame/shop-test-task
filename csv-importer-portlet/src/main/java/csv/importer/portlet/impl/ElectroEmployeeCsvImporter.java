package csv.importer.portlet.impl;

import shop.model.ElectroEmployee;
import shop.service.ElectroEmployeeLocalServiceUtil;
import shop.service.persistence.ElectroEmployeePK;

import java.util.HashMap;

public class ElectroEmployeeCsvImporter extends BaseCsvImporterImpl<ElectroEmployee> {
    @Override
    protected ElectroEmployee createModel() {
        return ElectroEmployeeLocalServiceUtil.createElectroEmployee(new ElectroEmployeePK());
    }

    @Override
    protected void saveModel(ElectroEmployee model) {
        ElectroEmployeeLocalServiceUtil.addElectroEmployee(model);
    }

    @Override
    protected void initColumnSetterMap() {
        columnSetterMap = new HashMap<>();
        columnSetterMap.put("employeeid", (electroEmployee, s) -> {
            electroEmployee.setEmployeeId(Long.parseLong(s));
        });
        columnSetterMap.put("etypeid", (electroEmployee, s) -> {
            electroEmployee.setETypeId(Long.parseLong(s));
        });
    }
}
