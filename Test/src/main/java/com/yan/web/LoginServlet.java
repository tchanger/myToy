package com.yan.web;

import com.yan.bean.User;
import com.yan.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        User user = new User(null,username,password);
        UserService us = new UserService();
        boolean result = us.login(user);
        if (result){
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            return;
        }
        request.getSession().setAttribute("error","账号或密码错误");
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
