package com.bridgelabz.opencsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCSVReader {
    private static final String SIMPLE_CSV_PATH = "./file.csv";

    public static void main(String[] args) throws IOException, CsvException {

        Reader reader = Files.newBufferedReader(Paths.get(SIMPLE_CSV_PATH));
        CSVReader csvReader = new CSVReader(reader);
        String[] record;
        while ((record =csvReader.readNext())!= null){
            System.out.println("Name: " + record[0]);
            System.out.println("Email: " + record[1]);
            System.out.println("Phone: " + record[2]);
            System.out.println("Country: " + record[3]);
            System.out.println("=======================");
        }

        System.out.println("**********************");
        // Reading all record at once into a list
        List<String[]> records = csvReader.readAll();

        for (String[] data:records) {
            System.out.println("Name: " + data[0]);
            System.out.println("Email: " + data[1]);
            System.out.println("Phone: " + data[2]);
            System.out.println("Country: " + data[3]);
            System.out.println("=======================");
        }



    }
}
