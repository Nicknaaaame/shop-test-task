package csv.importer.portlet.exception;

public class WrongColumnNameException extends RuntimeException {
    public WrongColumnNameException(String tableName) {
        super("Wrong column name: " + tableName);
    }
}
