package csv.importer.portlet.impl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import shop.model.Purchase;
import shop.service.PurchaseLocalServiceUtil;
import util.ShopProjectUtil;

import java.util.HashMap;

public class PurchaseCsvImporter extends BaseCsvImporterImpl<Purchase> {
    @Override
    protected Purchase createModel() {
        return PurchaseLocalServiceUtil.createPurchase(CounterLocalServiceUtil.increment());
    }

    @Override
    protected void saveModel(Purchase model) {
        PurchaseLocalServiceUtil.addPurchase(model);
    }

    @Override
    protected void initColumnSetterMap() {
        columnSetterMap = new HashMap<>();
        columnSetterMap.put("id", (purchase, s) -> {
            purchase.setId(Long.parseLong(s));
        });
        columnSetterMap.put("birthdate", (purchase, s) -> {
            purchase.setPurchaseDate(ShopProjectUtil.parseDateFromDB(s));
        });
        columnSetterMap.put("type", (purchase, s) -> {
            purchase.setType(Long.parseLong(s));
        });
        columnSetterMap.put("employeeId", (purchase, s) -> {
            purchase.setElectroId(Long.parseLong(s));
        });
        columnSetterMap.put("electroId", (purchase, s) -> {
            purchase.setElectroId(Long.parseLong(s));
        });
    }
}
