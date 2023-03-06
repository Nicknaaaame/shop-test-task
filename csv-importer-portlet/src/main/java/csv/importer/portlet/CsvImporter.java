package csv.importer.portlet;

import csv.importer.portlet.exception.WrongColumnNameException;

import java.io.Reader;

public interface CsvImporter {
    void importCsvFile(Reader reader) throws WrongColumnNameException;
}
