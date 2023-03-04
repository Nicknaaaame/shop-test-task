package csv.importer.portlet;

import java.io.Reader;

public interface CsvImporter {
    void importCsvFile(Reader reader);
}
