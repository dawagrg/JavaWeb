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
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

// Map servlet to "/register"
@WebServlet(name="registerUser", value = "/register")
public class RegisterServlet extends HttpServlet {

    // Handles GET request (load registration page)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Forward to register.jsp page
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/register.jsp");
        requestDispatcher.forward(req, resp);
    }

    // Handles POST request (form submission)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Dispatcher to return to register page
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/register.jsp");

        try {

            // Get form data
            String name = req.getParameter("fullname");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            // Validate input fields
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {

                // Set error message
                req.setAttribute("error", "Please fill the all fields");

                // Print message in console (for debugging)
                System.out.println("Please fill this all fields");

                // Forward back to form page
                requestDispatcher.forward(req, resp);
            }
            //password
            if(password.length() < 6){
                req.setAttribute("error", "Password must be greater than 6 character");
                requestDispatcher.forward(req, resp);
            }

            // Create User object
            User userObj = new User();

            // Set user details
            userObj.setName(name);
            userObj.setEmail(email);

//            userObj.setPassword(password);
            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
            userObj.setPassword(hashedPassword);

            // Create DAO object
            UserDaoInterface userDAO = new UserDao();

            // Insert user into database
            boolean result = userDAO.insertUser(userObj);

            // Check result of insertion
            if (result) {
                // Success message
                req.setAttribute("success", "Successfully User Added");
            } else {
                // Error message if insertion fails
                req.setAttribute("error", "Something went wrong");
            }

        } catch (Exception e) {
            // Catch any exception and show error message
            req.setAttribute("error", e.getMessage());
        }

        // Forward back to register page (with success or error message)
        requestDispatcher.forward(req, resp);
    }
}