package csv.importer.portlet.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import shop.model.Electronics;
import shop.service.ElectronicsLocalServiceUtil;

import java.util.HashMap;

public class ElectronicsCsvImporter extends BaseCsvImporterImpl<Electronics> {
    @Override
    protected Electronics createModel() {
        return ElectronicsLocalServiceUtil.createElectronics(CounterLocalServiceUtil.increment());
    }

    @Override
    protected void saveModel(Electronics model) {
        ElectronicsLocalServiceUtil.addElectronics(model);
    }

    @Override
    protected void initColumnSetterMap() {
        columnSetterMap = new HashMap<>();
        columnSetterMap.put("id", (electronics, s) -> {
            electronics.setId(Long.parseLong(s));
        });
        columnSetterMap.put("name", (electronics, s) -> {
            electronics.setName(s);
        });
        columnSetterMap.put("etypeid", (electronics, s) -> {
            electronics.setETypeId(Long.parseLong(s));
        });
        columnSetterMap.put("price", (electronics, s) -> {
            electronics.setPrice(Long.parseLong(s));
        });
        columnSetterMap.put("count", (electronics, s) -> {
            electronics.setCount(Integer.parseInt(s));
        });
        columnSetterMap.put("isinstock", (electronics, s) -> {
            electronics.setIsInStock(Boolean.parseBoolean(s));
        });
        columnSetterMap.put("isarchive", (electronics, s) -> {
            electronics.setIsArchive(Boolean.parseBoolean(s));
        });
        columnSetterMap.put("description", (electronics, s) -> {
            electronics.setDescription(s);
        });
    }
}
