package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dlyar
 */
public class ShopProjectUtil {
    public static Date parseDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(ShopProjectKeys.DATE_FORMAT);
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format");
        }
    }
}