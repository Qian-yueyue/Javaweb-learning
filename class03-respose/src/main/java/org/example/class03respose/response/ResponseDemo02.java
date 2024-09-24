package org.example.class03respose.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/responseDemo02")
public class ResponseDemo02 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
        ServletOutputStream outputStream=resp.getOutputStream();
        outputStream.write("你好".getBytes(StandardCharsets.UTF_8));
    }
}
