package csv.importer.portlet.impl;

import csv.importer.portlet.CsvImporter;
import csv.importer.portlet.exception.CsvFileReadException;
import csv.importer.portlet.exception.WrongColumnNameException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public abstract class BaseCsvImporterImpl<T> implements CsvImporter {
    private static final String COMMA_DELIMITER = ",";
    private static final String COMMA_QUOTE = "\"";
    protected Map<String, BiConsumer<T, String>> columnSetterMap;
    private List<BiConsumer<T, String>> columnSetterList;

    public BaseCsvImporterImpl() {
        initColumnSetterMap();
    }

    @Override
    public void importCsvFile(Reader reader) {
        try (BufferedReader buffReader = new BufferedReader(reader)) {
            initColumnSetterList(buffReader.readLine());
            String currentLine;
            while ((currentLine = buffReader.readLine()) != null) {
                T model = createModel();
                setValuesToModel(model, currentLine);
                saveModel(model);
            }
        } catch (IOException e) {
            throw new CsvFileReadException("Csv file is invalid");
        }
    }

    private void initColumnSetterList(String columnsLine) {
        String[] columns = removeQuote(columnsLine).split(COMMA_DELIMITER);
        columnSetterList = new ArrayList<>();
        for (String column : columns) {
            BiConsumer<T, String> setter = columnSetterMap.get(column.toLowerCase());
            if (setter == null)
                throw new WrongColumnNameException(column);
            columnSetterList.add(setter);
        }
    }

    private void setValuesToModel(T model, String valuesLine) {
        String[] values = removeQuote(valuesLine).split(COMMA_DELIMITER);
        int i = 0;
        for (String value : values) {
            BiConsumer<T, String> setter = columnSetterList.get(i++);
            setter.accept(model, value);
        }
    }

    protected String removeQuote(String value) {
        return value.replace(COMMA_QUOTE, "");
    }

    protected abstract T createModel();

    protected abstract void saveModel(T model);

    protected abstract void initColumnSetterMap();
}
