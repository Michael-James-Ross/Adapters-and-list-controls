package com.onyshchenko.artem.adaptersandlistcontrols.model;

public class UserInfo {
    private String name;
    private String surname;
    private Integer year;

    public UserInfo() {}

    public UserInfo(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
