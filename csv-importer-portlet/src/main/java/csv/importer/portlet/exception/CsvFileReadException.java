package csv.importer.portlet.exception;

public class CsvFileReadException extends RuntimeException {
    public CsvFileReadException() {
    }

    public CsvFileReadException(String message) {
        super(message);
    }
}
