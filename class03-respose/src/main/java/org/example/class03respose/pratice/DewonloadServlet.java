package org.example.class03respose.pratice;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class DewonloadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename=req.getParameter("filename");
        ServletContext servletContext=req.getServletContext();
        String realPath= servletContext.getRealPath("/img/"+filename);
        FileInputStream fileInputStream=new FileInputStream(realPath);
        String mineType=servletContext.getMimeType(filename);
        resp.setContentType(mineType);
        resp.setHeader("content-disponse","attachment;filename="+filename);
        ServletOutputStream outputStream=resp.getOutputStream();
        byte[] buff=new byte[1024*8];
        int len=0;
        while ((len=fileInputStream.read(buff))!=-1){
            outputStream.write(buff, 0, len);
        }
        fileInputStream.close();
    }
}
