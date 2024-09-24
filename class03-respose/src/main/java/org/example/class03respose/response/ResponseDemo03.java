package org.example.class03respose.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet("/responseType")
public class ResponseDemo03 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        switch (type) {
            case "img":
                getImage(req, resp);
                break;
            case "pdf":
                getPdf(req, resp);
                break;
            case "html":
                getHtml(req, resp);
                break;
            case "json":
                getJson(req, resp);
                break;
            default:
                break;
        }
    }
    private void getImage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/png");
        String realPathe= req.getServletContext().getRealPath("");
        File file= new File(realPathe+"/img/image.png");
        InputStream in= new FileInputStream(file);
        int read =0;
        ServletOutputStream outputStream=resp.getOutputStream();
        while ((read=in.read())!=-1){
            outputStream.write(read);
        }
        outputStream.flush();
        outputStream.close();
    }

    private void getPdf(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/pdf");
        String realPathe= req.getServletContext().getRealPath("");
        File file= new File(realPathe+"/pdf/PDF.pdf");
        InputStream in= new FileInputStream(file);
        int read =0;
        ServletOutputStream outputStream=resp.getOutputStream();
        while ((read=in.read())!=-1){
            outputStream.write(read);
        }
        outputStream.flush();
        outputStream.close();
    }

    private void getHtml(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String realPathe= req.getServletContext().getRealPath("");
        File file= new File(realPathe+"/html/login.html");
        InputStream in= new FileInputStream(file);
        int read =0;
        ServletOutputStream outputStream=resp.getOutputStream();
        while ((read=in.read())!=-1){
            outputStream.write(read);
        }
        outputStream.flush();
        outputStream.close();
    }

    private void getJson(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        String realPathe= req.getServletContext().getRealPath("");
        File file= new File(realPathe+"/json/package.json");
        InputStream in= new FileInputStream(file);
        int read =0;
        ServletOutputStream outputStream=resp.getOutputStream();
        while ((read=in.read())!=-1){
            outputStream.write(read);
        }
        outputStream.flush();
        outputStream.close();
    }
}
