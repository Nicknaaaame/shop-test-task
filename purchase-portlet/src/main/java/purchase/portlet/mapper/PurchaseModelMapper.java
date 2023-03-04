package purchase.portlet.mapper;

import com.liferay.portal.kernel.util.ParamUtil;
import shop.model.Purchase;
import util.ShopProjectUtil;

import javax.portlet.ActionRequest;
import java.util.Date;

public class PurchaseModelMapper {
    public static void map(ActionRequest request, Purchase purchase) {
        long eTypeId = ParamUtil.getLong(request, "eTypeId");
        long employeeId = ParamUtil.getLong(request, "employeeId");
        long electroId = ParamUtil.getLong(request, "electroId");
        Date purchaseDate = ShopProjectUtil.parseDateFromRequest(ParamUtil.getString(request, "purchaseDate"));

        purchase.setETypeId(eTypeId);
        purchase.setEmployeeId(employeeId);
        purchase.setElectroId(electroId);
        purchase.setPurchaseDate(purchaseDate);
    }
}
