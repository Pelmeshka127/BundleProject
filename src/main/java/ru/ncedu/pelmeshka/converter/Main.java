package ru.ncedu.pelmeshka.converter;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {
            throw new FileNotFoundException("Source file does not exist");
        } else {
            System.out.println(args[0]);
        }

        JsonWriter jsonWriter = new JsonWriter(args[0]);
        jsonWriter.Converter();
    }
}