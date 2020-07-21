package com.yan.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/visit")
public class VisitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd : HH.mm.ss");
        Cookie cookie = new Cookie("time",System.currentTimeMillis()+"");
        response.addCookie(cookie);
        String lastVisit = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if ("time".equals(c.getName())) {
                    lastVisit = c.getValue();
                    break;
                }
            }
        }
        if (lastVisit == null || "".equals(lastVisit)) {
            response.getWriter().print("你是第一次访问");
        }else{
            response.getWriter().print("你上次访问时间是：" + sdf.format(new Date(Long.parseLong(lastVisit))));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
