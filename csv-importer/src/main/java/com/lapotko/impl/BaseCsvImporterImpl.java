package com.lapotko.impl;

import com.lapotko.CsvImporter;
import com.lapotko.exception.CsvFileReadException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public abstract class BaseCsvImporterImpl<T> implements CsvImporter {
    private static final String COMMA_DELIMITER = ",";
    protected Map<String, BiConsumer<T, String>> columnSetterMap;
    private List<BiConsumer<T, String>> columnSetterList;

    @Override
    public void importCsvFile(FileReader reader) {
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
        String[] columns = columnsLine.split(COMMA_DELIMITER);
        columnSetterList = new ArrayList<>();
        for (String column : columns) {
            columnSetterList.add(columnSetterMap.get(column.toLowerCase()));
        }
    }

    private void setValuesToModel(T model, String valuesLine) {
        String[] values = valuesLine.split(COMMA_DELIMITER);
        int i = 0;
        for (String value : values) {
            BiConsumer<T, String> setter = columnSetterList.get(i);
            setter.accept(model, value);
        }
    }

    protected abstract T createModel();

    protected abstract void saveModel(T model);
}
