package ru.ncedu.pelmeshka.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest {
    @Test
    void jsonTest() {
        String path = "src/main/resources/csv/test.csv";

        JsonWriter jsonWriter = new JsonWriter(path);
        jsonWriter.Converter();
    }
}