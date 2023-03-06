package csv.importer.portlet.exception;

public class WrongColumnNameException extends Exception {
    public WrongColumnNameException(String columnName) {
        super("Wrong column name: " + columnName);
    }
}
