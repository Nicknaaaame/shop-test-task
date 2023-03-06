package csv.importer.portlet.exception;

public class WrongTableNameException extends Exception {
    public WrongTableNameException(String tableName) {
        super("Wrong table name: " + tableName + ". Should be 'shop_[table_name].csv'");
    }
}
