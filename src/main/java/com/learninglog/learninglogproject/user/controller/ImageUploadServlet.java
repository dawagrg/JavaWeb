package com.learninglog.learninglogproject.user.controller;

import com.learninglog.learninglogproject.user.model.dao.ImageDao;
import com.learninglog.learninglogproject.utils.ImageUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;

@WebServlet("/image")
@MultipartConfig
public class ImageUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("pages/image-upload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Part imagePart = req.getPart("image");
        String imageName = ImageUtils.saveImage(imagePart, req);
        if (imageName == null){
            req.setAttribute("error", "Unable to upload image");
        }
        else {
            try{
                boolean result = ImageDao.insertImage(name, "images/"+imageName);
            }catch (Exception e){
                req.setAttribute("error", e.getMessage());
            }

        }
        req.getRequestDispatcher("pages/image-upload.jsp").forward(req, resp);
    }
}
