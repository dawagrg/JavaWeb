package com.learninglog.learninglogproject.topic.model.dao;

import com.learninglog.learninglogproject.topic.model.Topic;
import com.learninglog.learninglogproject.utils.DBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// insert topic
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

    // fetch topic
    public static List<Topic> fetchTopics() throws SQLException{
        String query = "SELECT * FROM topic";
        try(Connection conn = DBConnection.getConnection();
        PreparedStatement st = conn.prepareStatement(query)
        ){
            ResultSet rs = st.executeQuery();

            List<Topic> topicList = new ArrayList<>();
            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int userId = rs.getInt(3);
                Timestamp crDate = rs.getTimestamp(4);
                Timestamp upDate = rs.getTimestamp(5);

                Topic topicObj = new Topic(id, name, userId, crDate, upDate);
                topicList.add(topicObj);
            }
            return topicList;
        }
    }
    public Topic fetchTopicById(int id) throws SQLException{
        String query = "SELECT * FROM topic WHERE id = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(query)
        ){
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                String name = rs.getString("name");
                int userId = rs.getInt("user_id");
                Timestamp createdDate = rs.getTimestamp("createdDate");
                Timestamp updatedDate = rs.getTimestamp("updatedDate");

                Topic topic = new Topic(id, name, userId, createdDate, updatedDate);
                return topic;
            }
            else{
                return null;
            }
        }
    }
}
