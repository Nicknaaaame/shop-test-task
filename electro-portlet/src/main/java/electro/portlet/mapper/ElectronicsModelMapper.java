package electro.portlet.mapper;

import com.liferay.portal.kernel.util.ParamUtil;
import shop.model.Electronics;

import javax.portlet.ActionRequest;

public class ElectronicsModelMapper {
    public static void map(ActionRequest request, Electronics electronics) {
        String name = ParamUtil.getString(request, "name");
        long eTypeId = ParamUtil.getLong(request, "eTypeId");
        long price = ParamUtil.getLong(request, "price");
        int count = ParamUtil.getInteger(request, "count");
        boolean isInStock = ParamUtil.getBoolean(request, "isInStock");
        boolean isArchive = ParamUtil.getBoolean(request, "isArchive");
        String description = ParamUtil.getString(request, "description");

        electronics.setName(name);
        electronics.setETypeId(eTypeId);
        electronics.setPrice(price);
        electronics.setCount(count);
        electronics.setIsInStock(isInStock);
        electronics.setIsArchive(isArchive);
        electronics.setDescription(description);
    }
}
