package com.learninglog.learninglogproject.user.controller;

import com.learninglog.learninglogproject.user.model.User;
import com.learninglog.learninglogproject.user.model.dao.UserDao;
import com.learninglog.learninglogproject.user.model.dao.UserDaoInterface;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected  void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("pages/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if(email.isEmpty() || password.isEmpty()){
            req.setAttribute("error","Please fill all the fields");
            req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
        }
        try{
            UserDaoInterface userDao = new UserDao();
            User userObj = userDao.loginUser(email, password);
            if(userObj == null){
                req.setAttribute("error", "Invalid username or password");
                req.getRequestDispatcher("pages/login").forward(req, resp);
            }else{

            }
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
        }
    }
}
