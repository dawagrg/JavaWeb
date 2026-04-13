package com.learninglog.learninglogproject.topic.controller;

import com.learninglog.learninglogproject.topic.model.Topic;
import com.learninglog.learninglogproject.topic.model.dao.TopicDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet("/topic")
public class TopicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if("list".equals(action)){
            try {
                List<Topic> topicList = TopicDao.fetchTopics();
                req.setAttribute("topics",topicList);

            }catch (Exception e){
                req.setAttribute("error","Unable to fetch ");
            }
            req.getRequestDispatcher("pages/topic-list.jsp").forward(req,resp);
        }
        if("edit".equals(action)){
            TopicDao dao = new TopicDao();
            try{
                int id = Integer.parseInt(req.getParameter("id"));
                Topic topicObjById = dao.fetchTopicById(id);
                if(topicObjById == null){
                    req.setAttribute("error", "Unable to fetch topic by this id");
                    req.getRequestDispatcher("pages/topic-list.jsp").forward(req, resp);

                }else {
                    req.setAttribute("topic", topicObjById);
                    req.getRequestDispatcher("pages/edit-topic.jsp").forward(req, resp);
                }
            }catch (Exception e){

            }
        }
        req.getRequestDispatcher("pages/add-topic.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse rest){
        String  action = req.getParameter("action");

        if(action=="add"){
            String topicName = req.getParameter("topic-name");
            int userId = Integer.parseInt(req.getParameter("userId"));
            Timestamp createdAt = new Timestamp(System.currentTimeMillis());
            Timestamp updatedDate = createdAt;

            Topic topicObj = new Topic();
            topicObj.setName(topicName);
            topicObj.setUserId(userId);
            topicObj.setCreatedAt(createdAt);
            topicObj.setUpdatedAt(updatedDate);

            try{
                boolean result = TopicDao.insertTopic(topicObj);
                if(result){
                    req.setAttribute("success", "Successfully topic added");
                }
                else {
                    req.setAttribute("error","Something went wrong");
                }
                req.getRequestDispatcher("pages/add-topic.jsp").forward(req,rest);
            }
            catch (Exception e){

            }
            // Call the topic dao


        }
    }
}