package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dlyar
 */
public class ShopProjectUtil {
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
}