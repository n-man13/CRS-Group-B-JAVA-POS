package com.lti.document;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "BasicDataDocument")
public class BasicDataDocument implements Serializable {
    
    @Id
    private int id;

    @Field("name")
    private String name;

    @Field("dateOfBirth")
    private String dateOfBirth;

    @Field("insertTime")
    private String insertTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return "BasicDataDocument [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", insertTime="
                + insertTime + "]";
    }

    
}
