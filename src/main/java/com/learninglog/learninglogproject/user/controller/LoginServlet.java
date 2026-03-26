package com.learninglog.learninglogproject.user.controller;

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
    }
}
