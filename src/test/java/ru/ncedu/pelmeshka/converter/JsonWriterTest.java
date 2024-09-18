package ru.ncedu.pelmeshka.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest {
    @Test
    void jsonTest() {
        String path = "src/main/resources/csv/1.csv";

        JsonWriter jsonWriter = new JsonWriter(path);
        System.out.println(jsonWriter.getJsonFileName());
        jsonWriter.jsonConverter();
    }
}