package exception;

import com.liferay.portal.kernel.exception.PortalException;

public class DateValidationException extends PortalException {
    public DateValidationException() {
        super("Date should in the past");
    }
}
