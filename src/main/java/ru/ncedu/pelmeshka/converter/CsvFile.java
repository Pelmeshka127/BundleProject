package ru.ncedu.pelmeshka.converter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public final class CsvFile {
    private static int INITIAL_CAPACITY = 20;

    private String fileName;
    private ArrayList<String> strings = new ArrayList<>(INITIAL_CAPACITY);

    public CsvFile(String fileName) {
        this.fileName   = fileName;
        File file       = new File(fileName);
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext()) {
                strings.add(scan.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File " + fileName + " does not found");
            e.printStackTrace();
        }
    }

    public String getFileName() {
        return fileName;
    }

    public ArrayList<String> getStrings() {
        return strings;
    }

    public void printFile() {
        for (int i = 0; i < strings.size(); i++) {
            System.out.print(strings.get(i));
        }
    }

    @Override
    public String toString() {
        return "CsvFile{" +
                "fileName='" + fileName + '\'' +
                ", strings=" + strings +
                '}';
    }
}
