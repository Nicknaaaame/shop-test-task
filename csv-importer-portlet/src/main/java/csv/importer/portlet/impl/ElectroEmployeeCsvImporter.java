package csv.importer.portlet.impl;

import shop.model.ElectroEmployee;

public class ElectroEmployeeCsvImporter extends BaseCsvImporterImpl<ElectroEmployee> {
    @Override
    protected ElectroEmployee createModel() {
//        return ElectroEmployeeLocalServiceUtil.createElectroEmployee();
        throw new UnsupportedOperationException();
    }

    @Override
    protected void saveModel(ElectroEmployee model) {

    }

    @Override
    protected void initColumnSetterMap() {

    }
}
