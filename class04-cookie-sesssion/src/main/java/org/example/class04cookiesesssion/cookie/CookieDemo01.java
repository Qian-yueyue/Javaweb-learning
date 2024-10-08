package org.example.class04cookiesesssion.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookieDemo01")
public class CookieDemo01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException , IOException {
        Cookie cookie = new Cookie("username","zhangsan");
        resp.addCookie(cookie);
        cookie.setMaxAge(60*60*24*7);
    }
}