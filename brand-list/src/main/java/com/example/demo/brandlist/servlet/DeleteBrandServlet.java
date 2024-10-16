package com.example.demo.brandlist.servlet;

import com.alibaba.fastjson.JSON;
import com.example.demo.brandlist.entity.Brand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteBrand")
public class DeleteBrandServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        Integer id = JSON.parseObject(requestBody.toString(), Integer.class);
        List<Brand> brands = (List<Brand>) req.getServletContext().getAttribute("brands");
        if (brands != null) {
            brands.removeIf(brand -> brand.getId().equals(id));
            req.getServletContext().setAttribute("brands", brands);
            resp.getWriter().write("品牌删除成功");
        } else {
            resp.getWriter().write("品牌没有找到");
        }
    }
}
