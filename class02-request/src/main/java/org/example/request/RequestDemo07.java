package org.example.request;


import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/requestDemo07")
public class RequestDemo07 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("attribute"+req.getAttribute("msg"));
        req.removeAttribute("msg");

        ServletContext servletContext= req.getServletContext();
        String info =String.valueOf(servletContext.getAttribute("info"));
        System.out.println("info"+info);
    }
}