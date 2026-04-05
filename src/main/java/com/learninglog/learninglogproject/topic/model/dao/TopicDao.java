package com.learninglog.learninglogproject.topic.model.dao;

import com.learninglog.learninglogproject.topic.model.Topic;
import com.learninglog.learninglogproject.utils.DBConnection;

import java.io.IOException;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TopicDao {
    public static boolean insertTopic(Topic topic) throws SQLException, IOException {
        String name = topic.getName();
        int userId = topic.getUserId();;
        Timestamp createdAt = topic.getCreatedAt();
        Timestamp updatedAt = topic.getUpdatedAt();

        String query = "INSERT INTO topic(name, user_id, craeteddate, updatedDate)" + "VALUE(?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(query);
             ){
            st.setString(1, name);
            st.setInt(2,userId);
            st.setTimestamp(3, createdAt);
            st.setTimestamp(4, updatedAt);
            int rowsInserted = st.executeUpdate();
            if (rowsInserted > 0){
                return true;
            }else{
                return false;
            }
        }
    }
}
