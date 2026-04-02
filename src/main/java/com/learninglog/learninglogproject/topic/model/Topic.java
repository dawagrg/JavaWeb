package com.learninglog.learninglogproject.topic.model;

import java.security.Timestamp;

public class Topic {
    private int id;
    private  String name;
    private int userId;
    private Timestamp createdDate;


    public Topic() {}

    public Topic(int id, String name, int userId, Timestamp createdDate, Timestamp updatedDate) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    private Timestamp updatedDate;
}
