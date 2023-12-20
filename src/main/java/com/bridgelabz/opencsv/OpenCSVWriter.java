package com.bridgelabz.opencsv;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class OpenCSVWriter {
    private static final String SIMPLE_CSV_PATH = "./file.csv";

    public static void main(String[] args) throws
            IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        Writer writer = Files.newBufferedWriter(Paths.get(SIMPLE_CSV_PATH));
        StatefulBeanToCsv<CSVUser>  statefulBeanToCsv = new StatefulBeanToCsvBuilder(writer)
                                                        .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                                                        .build();
        ArrayList<CSVUser> users = new ArrayList<>();

//        users.add(new CSVUser("Harsh","harsh@gamil.com","7485963210","India"));
//        users.add(new CSVUser("Sundar Pichai","s.pichai@gamil.com","8523697410","India"));
        System.out.println(users);
        statefulBeanToCsv.write(users);
        writer.close();
    }
}
