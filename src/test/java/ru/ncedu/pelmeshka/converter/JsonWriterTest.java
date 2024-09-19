package ru.ncedu.pelmeshka.converter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest {
    @Test
    void jsonTest() {
        String path = "src/main/resources/csv/test.csv";

        JsonWriter jsonWriter = new JsonWriter(path);
        jsonWriter.Converter();

//        char nonAscii = 0x00FF;
//        String asciiText = "Hello";
//        System.out.println(asciiText.matches("\\A\\p{ASCII}*\\z"));
//        System.out.println(nonAsciiText.matches("\\A\\p{ASCII}*\\z"));
    }
}