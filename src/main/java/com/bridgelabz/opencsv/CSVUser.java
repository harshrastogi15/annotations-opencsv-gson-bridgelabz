package com.bridgelabz.opencsv;

import com.opencsv.bean.CsvBindByName;

public class CSVUser {
    @CsvBindByName
    private String name;

    @CsvBindByName
    private String email;

    @CsvBindByName
    private String phone;

    @CsvBindByName
    private String country;

//    public CSVUser(String name, String email, String phone, String country) {
//        this.name = name;
//        this.email = email;
//        this.phone = phone;
//        this.country = country;
//    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }


    public String getPhone() {
        return this.phone;
    }


    public String getCountry() {
        return this.country;
    }


    @Override
    public String toString() {
        return "CSVUser{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
