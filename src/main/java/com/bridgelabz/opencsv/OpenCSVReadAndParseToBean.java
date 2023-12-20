package com.bridgelabz.opencsv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class OpenCSVReadAndParseToBean {
    private static final String SIMPLE_CSV_PATH = "./file.csv";

    public static void main(String[] args) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(SIMPLE_CSV_PATH));

        CsvToBean<CSVUser> csvUsers = new CsvToBeanBuilder(reader)
                                        .withType(CSVUser.class)
                                        .withIgnoreLeadingWhiteSpace(true)
                                        .build();
        Iterator<CSVUser> csvUserIterator = csvUsers.iterator();
        while (csvUserIterator.hasNext()){
            CSVUser csvUser = csvUserIterator.next();
            System.out.println("Name: " + csvUser.getName());
            System.out.println("Email: " + csvUser.getEmail());
            System.out.println("Phone: " + csvUser.getPhone());
            System.out.println("Country: " + csvUser.getCountry());
            System.out.println("=======================");
        }
    }
}
