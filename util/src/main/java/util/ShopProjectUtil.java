package util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dlyar
 */
public class ShopProjectUtil {
    private static final Log _log = LogFactoryUtil.getLog(ShopProjectUtil.class);

    public static Date parseDateFromRequest(String date) {
        return parseDate(date, ShopProjectKeys.DATE_INPUT_FORMAT);
    }

    public static Date parseDateFromDB(String date) {
        return parseDate(date, ShopProjectKeys.DATE_FROM_DB_FORMAT);
    }

    public static Date parseDate(String date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format");
        }
    }

    public static void handleException(ActionRequest request, ActionResponse response, Exception ex) {
        String message = ex.getMessage();
        response.setRenderParameter(ShopProjectKeys.EXCEPTION_MESSAGE, message);
        SessionErrors.add(request, ShopProjectKeys.EXCEPTION_KEY);
        _log.error(message);
    }
}