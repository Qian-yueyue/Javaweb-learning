package org.example.class03respose.pratice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/verifyCode")
public class VerifyCode extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 160;
        int height =45;

        BufferedImage image= new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0,0,width,height);
        String str="12345678wasdefQWERTY";
        Random random=new Random();
        for (int i=0;i<=5;i++){
            int index=random.nextInt(str.length());
            char ch=str.charAt(index);
            Color color=new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
            g.setColor(color);
            Font font=new Font("Dialog",Font.BOLD,20);
            g.setFont(font);
            g.drawString(ch+"",width/5*i,height/2);
        }
        for (int i = 0; i < 10; i++) {
            int x1=random.nextInt(width);
            int x2=random.nextInt(width);
            int y1=random.nextInt(height);
            int y2=random.nextInt(height);
            Color color=new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
            g.setColor(color);
            g.drawLine(x1,x2,y1,y2);
        }
        for(int i = 0;i<500;i++) {
            Random ran = new Random();
            int x = ran.nextInt(width);
            int y = ran.nextInt(width);
            g.drawOval(x, y, 1, 1);
        }
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
}
