package ru.ncedu.pelmeshka.converter;

public class Converter {
    private String csvFile;
    private String jsonFile;

    public Converter(String csvFile) {
        this.csvFile = csvFile;
        this.jsonFile = csvFile.substring(0, csvFile.indexOf('.') + 1) + "json";
    }

    @Override
    public String toString() {
        return "Converter{" +
                "csvFile='" + csvFile + '\'' +
                ", jsonFile='" + jsonFile + '\'' +
                '}';
    }
}
