package com.bridgelabz.gson;

import com.bridgelabz.opencsv.CSVUser;
import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WriteToJson {

    private static final String CSV_FILE_PATH = "./file.csv";
    private static final String JSON_FILE_PATH = "./file.json";
    public List<CSVUser> readCSV(){
        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class)
                                    .withIgnoreLeadingWhiteSpace(true)
                                    .build();
            List<CSVUser> csvUserList = csvToBean.parse();

            reader.close();
            return csvUserList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void writeJson(List<CSVUser> csvUserList){
        try {
            Gson gson = new Gson();
            String json = gson.toJson(csvUserList);
            Writer writer = Files.newBufferedWriter(Paths.get(JSON_FILE_PATH));
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        WriteToJson writeToJson = new WriteToJson();
        List<CSVUser> csvUserList = writeToJson.readCSV();
        System.out.println(csvUserList);
        writeToJson.writeJson(csvUserList);
    }
}
