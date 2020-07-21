package com.yan.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        String remember = request.getParameter("remember");
        if ("on".equals(remember)){
            Cookie user = new Cookie("user",username);
            response.addCookie(user);
        }else {
            Cookie user = new Cookie("user","");
            response.addCookie(user);
        }
        String Rcode = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        System.out.println(Rcode);
        if (Rcode.equals(code)){
            if ("admin".equals(username) && "1234".equals(password)){
                response.getWriter().print("登录成功");
            }else {
                request.setAttribute("message","账号或密码输入错误");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }else {
            request.setAttribute("message","验证码输入错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
