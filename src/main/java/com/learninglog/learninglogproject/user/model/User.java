package com.learninglog.learninglogproject.user.model;

// User model class (POJO)
// This class represents a User entity and is used to transfer data
public class User {

    // Fields (attributes of User)
    private int id;          // Unique ID of the user (usually primary key in DB)
    private String name;     // Full name of the user
    private String email;    // Email address of the user
    private String password; // Password of the user

    // Parameterized constructor (used to create object with all values)
    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Default constructor (required for flexibility / frameworks)
    public User(){}

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
}