package org.example.bookonline.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.bookonline.dao.UserDao;
import org.example.bookonline.dao.impl.UserDaoImpl;
import org.example.bookonline.entity.User;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //    获取表单数据
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        String avatar = req.getParameter("avatar");
        String address = req.getParameter("address");

        //      判定并调用注册功能
        if (account != null && password != null && nickname != null){
            UserDao userDao = new UserDaoImpl();
            User user = User.builder().account(account).password(password).
                    nickname(nickname).address(address).avatar(avatar).build();
            userDao.insertUser(user);
            //        重定向回到 /login.html，进入 LoginServlet
            resp.sendRedirect("/login.html");
        }else{
            //        注册失败，设置好响应对象字符集和响应类型
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("<script>alert（'注册失败'）;location.href='/';</script>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}

