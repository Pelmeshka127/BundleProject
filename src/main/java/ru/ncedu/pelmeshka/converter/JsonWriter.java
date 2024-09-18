package ru.ncedu.pelmeshka.converter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonWriter {
    private String  jsonFileName;

    public JsonWriter(String path) {
        this.jsonFileName = path.replaceAll("csv", "json");
    }

    public void jsonConverter() {
        File file = new File(jsonFileName);
        try {
            file.createNewFile();
//            makeJson(file);
        } catch (FileNotFoundException e) {
            System.err.println("Failed to find file " + jsonFileName + " after creating");
        }
        catch (IOException e) {
            System.err.println("Failed create new file " + jsonFileName);
            e.printStackTrace();
        }
    }

    public String getJsonFileName() {
        return jsonFileName ;
    }

}
