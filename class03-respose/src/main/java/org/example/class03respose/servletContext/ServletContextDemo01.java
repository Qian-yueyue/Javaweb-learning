package org.example.class03respose.servletContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servletContextDemo01")
public class ServletContextDemo01 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext=req.getServletContext();
        String fileName="package.json";
        String mimetype= servletContext.getMimeType(fileName);
        System.out.println(mimetype);
    }
}
