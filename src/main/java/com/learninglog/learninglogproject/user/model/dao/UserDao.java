package com.learninglog.learninglogproject.user.model.dao;

import com.learninglog.learninglogproject.user.model.User;
import com.learninglog.learninglogproject.utils.DBConnection;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// DAO class responsible for database operations related to User
public class UserDao implements UserDaoInterface {

    // Method to insert a new user into database
    @Override
    public boolean insertUser(User user) throws SQLException, IOException {

        // SQL query with placeholders (PreparedStatement prevents SQL Injection)
        String query = "INSERT INTO user (name, email, password) VALUES(?,?,?)";

        // Try-with-resources (automatically closes connection and statement)
        try (
                // Get database connection
                Connection conn = DBConnection.getConnection();

                // Prepare SQL statement
                PreparedStatement preparedStatement = conn.prepareStatement(query)
        ) {

            // Get values from User object
            String name = user.getName();
            String email = user.getEmail();
            String password = user.getPassword();

            // Set values into query
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            // Execute insert query
            int insertedRow = preparedStatement.executeUpdate();

            // Check if row is inserted successfully
            if (insertedRow > 0) {
                return true;   // success
            } else {
                return false;  // failure
            }
        }
    }


    public User loginUser(String email, String password) throws SQLException {

        String query = "SELECT * FROM user WHERE email = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(query)
        ) {
            st.setString(1, email);
            // execute query
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String storedHashedPassword = rs.getString("password");
                // boolean isValidPw = BCrypt.checkpw(password, storedHashedPassword);
                if (BCrypt.checkpw(password, storedHashedPassword)) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    User userObj = new User(id, name, email, storedHashedPassword);
                    return userObj;
                }
                else{
                    return null;
                }
            }
            else {
                return null;
            }
        }
    }
}

//    public boolean checkEmailAndPassword(String email, String password) throws SQLException{
//        String query = "SELECT id FROM  user WHERE email = ? AND password = ?";
//        try(Connection conn = DBConnection.getConnection();
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//        ){
//            preparedStatement.setString(1, email);
//            preparedStatement.setString(2, password);
//
//            ResultSet rs = preparedStatement.executeQuery();
//            if (rs.next()){
//                return true;
//            }else {
//                return false; //failure
//            }
//        }
//    }
//}