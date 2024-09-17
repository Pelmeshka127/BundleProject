package ru.ncedu.pelmeshka.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CsvFileTest {
    @Test
    void testCsv() {
        String path = "/Users/pelmeshka127/Desktop/Java/BundleProject/src/main/resources/csv/1.csv";
        CsvFile csvFile = new CsvFile(path);
        csvFile.printFile();
    }
}