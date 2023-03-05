package csv.importer.portlet.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import shop.model.ElectroType;
import shop.service.ElectroTypeLocalServiceUtil;

import java.util.HashMap;

public class ElectroTypeCsvImporter extends BaseCsvImporterImpl<ElectroType> {
    @Override
    protected ElectroType createModel() {
        return ElectroTypeLocalServiceUtil.createElectroType(CounterLocalServiceUtil.increment());
    }

    @Override
    protected void saveModel(ElectroType model) {
        ElectroTypeLocalServiceUtil.addElectroType(model);
    }

    @Override
    protected void initColumnSetterMap() {
        columnSetterMap = new HashMap<>();
        columnSetterMap.put("id_", (electroType, s) -> {
            electroType.setId(Long.parseLong(s));
        });
        columnSetterMap.put("name", (electroType, s) -> {
            electroType.setName(s);
        });
    }
}
