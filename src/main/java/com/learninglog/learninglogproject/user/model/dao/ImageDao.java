package com.learninglog.learninglogproject.user.model.dao;

import com.learninglog.learninglogproject.utils.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageDao {
    public static boolean insertImage(String name, String imagePath) throws SQLException, IOException {
//        table
//        id auto_increment, name varchar, image_path varchar
        String query = "INSERT INTO image_upload (name, image_path)" + "VALUES(?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(query)) {
            st.setString(1, name);
            st.setString(2, imagePath);
            int rowsAdded = st.executeUpdate();
            if (rowsAdded > 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}