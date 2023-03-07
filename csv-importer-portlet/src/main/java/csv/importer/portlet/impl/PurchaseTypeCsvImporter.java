package csv.importer.portlet.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import shop.model.PurchaseType;
import shop.service.PurchaseTypeLocalServiceUtil;

import java.util.HashMap;

public class PurchaseTypeCsvImporter extends BaseCsvImporterImpl<PurchaseType> {
    @Override
    protected PurchaseType createModel() {
        return PurchaseTypeLocalServiceUtil.createPurchaseType(CounterLocalServiceUtil.increment());
    }

    @Override
    protected void saveModel(PurchaseType model) {
        PurchaseTypeLocalServiceUtil.addPurchaseType(model);
    }

    @Override
    protected void initColumnSetterMap() {
        columnSetterMap = new HashMap<>();
        columnSetterMap.put("id", (purchaseType, s) -> {
            purchaseType.setId(Long.parseLong(s));
        });
        columnSetterMap.put("name", (purchaseType, s) -> {
            purchaseType.setName(s);
        });
    }
}
