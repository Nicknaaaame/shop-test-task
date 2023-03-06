package csv.importer.portlet.exception;

public class WrongColumnNameException extends Exception {
    public WrongColumnNameException(String tableName) {
        super("Wrong column name: " + tableName);
    }
}
