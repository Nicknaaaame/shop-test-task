package csv.importer.portlet.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import shop.model.PositionType;
import shop.service.PositionTypeLocalServiceUtil;

import java.util.HashMap;

public class PositionTypeCsvImporter extends BaseCsvImporterImpl<PositionType> {
    @Override
    protected PositionType createModel() {
        return PositionTypeLocalServiceUtil.createPositionType(CounterLocalServiceUtil.increment());
    }

    @Override
    protected void saveModel(PositionType model) {
        PositionTypeLocalServiceUtil.addPositionType(model);
    }

    @Override
    protected void initColumnSetterMap() {
        columnSetterMap = new HashMap<>();
        columnSetterMap.put("id_", (positionType, s) -> {
            positionType.setId(Long.parseLong(s));
        });
        columnSetterMap.put("name", (positionType, s) -> {
            positionType.setName(s);
        });
    }
}
