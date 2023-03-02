package com.lapotko;

import java.io.FileReader;

public interface CsvImporter {
    void importCsvFile(FileReader reader);
}
