package org.example.class03respose.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        resp.setHeader("location", "/responseDemo02");
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("ResponseDemo01");
    }

}
