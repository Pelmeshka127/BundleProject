package ru.ncedu.pelmeshka.converter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class for implementation of csv to json converting.
 * Includes:
 * jsonFile - path of destination json file;
 * srcFile - path of source csv file;
 * strings - strings of source file, which will be executed for making json file;
 */

public class JsonWriter {
    private static int INITIAL_CAPACITY = 20;

    private File jsonFile;
    private File srcFile;
    ArrayList<String> strings;

    public JsonWriter(String path) {
        String srcFileName  = path;
        String jsonFileName = path.replaceAll("csv", "json");

        this.jsonFile = new File(jsonFileName);
        this.srcFile  = new File(srcFileName);
        this.strings  = new ArrayList<>(INITIAL_CAPACITY);

        try (Scanner scan = new Scanner(srcFile)){
            while(scan.hasNextLine()) {
                strings.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to find scr file " + srcFileName);
            e.printStackTrace();
        }

        try {
            jsonFile.createNewFile();
        } catch (IOException e) {
            System.err.println("Failed to create new json file " + jsonFileName);
            e.printStackTrace();
        }
    }

    /**
     * Main method of class which starts the process of converting;
     * Uses private method "printJson" which implements all logic
     */
    public void Converter() {
        try (PrintWriter printer = new PrintWriter(jsonFile)) {
            printJson(printer);
        } catch (FileNotFoundException e) {
            System.err.println("Failed to find new created file " + jsonFile.getName());
            e.printStackTrace();
        }
    }

    /**
     * Method prints converted strings to json file depending on their structure
     * @param printer is object of PrintWriter class that prints strings to destination file
     */
    private void printJson(PrintWriter printer) {
        printer.println("{");
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).charAt(0) == '#') {
                printer.println("\t// " + strings.get(i).substring(1, strings.get(i).length()));
            } else {
                String[] arr = strings.get(i).split(",");
                printer.print("\t\"" + printString(arr[0]) + "\": ");
                printer.print("\"" + printString(arr[1]) + "\"");
                if (i != strings.size() - 1) {
                    printer.print(",");
                }
                printer.println();
            }
        }
        printer.println("}");
    }

    /**
     * Method implements converting string to unicode or ASCII
     * @param str source string to print in json file
     * @return converted string
     */
    private String printString(String str) {
        if (isASCII(str)) {
            return str;
        } else {
            StringBuilder newStr = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) > 128) {
                    newStr.append(getUnicodeCharacterOfChar(str.charAt(i)));
                } else {
                    newStr.append(str.charAt(i));
                }
            }
            return newStr.toString();
        }
    }

    private String getUnicodeCharacterOfChar(char ch) {
        return String.format("\\u%04x", (int) ch);
    }

    private boolean isASCII(String str) {
        return str.matches("\\A\\p{ASCII}*\\z");
    }
}

