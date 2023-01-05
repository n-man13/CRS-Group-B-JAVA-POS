package com.lti.dto;

import java.util.Date;

public class BasicData {
    String name;
    Date dateOfBirth;
    Date insertTime;

    public BasicData(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return "BasicData [name=" + name + ", dateOfBirth=" + dateOfBirth + ", insertTime=" + insertTime + "]";
    }
    
}
