package com.lti.dto;

public class BasicData {
    String name;
    String dateOfBirth;
    String insertTime;

    public BasicData(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public  String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return "BasicData [name=" + name + ", dateOfBirth=" + dateOfBirth + ", insertTime=" + insertTime + "]";
    }
    
}
