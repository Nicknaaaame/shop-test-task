package csv.importer.portlet;


import csv.importer.portlet.impl.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipArchiveImporter {
    private Map<String, CsvImporter> tableToImporterMap;

    public ZipArchiveImporter() {
        tableToImporterMap = new HashMap<>();
        tableToImporterMap.put("shop_employee.csv", new EmployeeCsvImporter());
        tableToImporterMap.put("shop_electronics.csv", new ElectronicsCsvImporter());
        tableToImporterMap.put("shop_purchase.csv", new PurchaseCsvImporter());
        tableToImporterMap.put("shop_positiontype.csv", new PositionTypeCsvImporter());
        tableToImporterMap.put("shop_electrotype.csv", new ElectroTypeCsvImporter());
    }

    public void importFromZipArchive(File archive) throws IOException {
        try (ZipFile zipFile = new ZipFile(archive)) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = entries.nextElement();
                try (InputStreamReader reader = new InputStreamReader(zipFile.getInputStream(zipEntry))) {
                    tableToImporterMap.get(zipEntry.getName()).importCsvFile(reader);
                }
            }
        }
    }
}
