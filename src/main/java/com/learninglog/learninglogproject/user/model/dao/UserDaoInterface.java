package com.learninglog.learninglogproject.user.model.dao;

import com.learninglog.learninglogproject.user.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

// Interface for User DAO (defines database operations related to User)
public interface UserDaoInterface {

    // Method to insert a new user into database
    // Returns true if insertion is successful, otherwise false
    // Throws SQLException for database errors
    // Throws IOException for input/output related issues
    public boolean insertUser(User user) throws SQLException, IOException;
    public User loginUser(String email, String password) throws SQLException;
    // Future method to fetch list of users (currently commented)
    // public List<User> fetchUser();
}