package ru.ncedu.pelmeshka.converter;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class OpenFileTest {
    @Test
    void openFile() throws FileNotFoundException {
        String path     = "src/main/resources/csv/1.csv";
        File file       = new File(path);
        Scanner scan    = new Scanner(file);

        while (scan.hasNext()) {
            System.out.println(scan.nextLine());
        }
    }
}