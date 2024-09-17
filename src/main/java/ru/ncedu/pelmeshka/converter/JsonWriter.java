package ru.ncedu.pelmeshka.converter;

import java.util.ArrayList;

public class JsonWriter {
    private String jsonFile;
    private ArrayList<String> strings;

    public JsonWriter(CsvFile csvFile) {
        String srcFile = csvFile.getFileName();
        this.jsonFile = srcFile.substring(0, srcFile.length() - 3) + "json";
    }

    public String getJsonFile() {
        return jsonFile;
    }

}
