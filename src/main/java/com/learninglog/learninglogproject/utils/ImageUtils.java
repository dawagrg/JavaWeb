package com.learninglog.learninglogproject.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

import java.io.File;


public class ImageUtils {
    public static String saveImage(Part imagePart, HttpServletRequest req){
        try {
            String uploadPath = "C:\\Users\\user\\IdeaProjects\\learninglog\\src\\main\\webapp\\images";
            File uploadDirectory = new File(uploadPath);
            if (uploadDirectory.exists()) {
                uploadDirectory.mkdirs();
            }
            String imageName = imagePart.getSubmittedFileName() + ".png";

            imagePart.write(uploadPath + File.separator + imageName);
            return imageName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
