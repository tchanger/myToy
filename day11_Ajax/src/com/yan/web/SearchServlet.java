package com.yan.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yan.bean.User;
import com.yan.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userService us = new userService();
        String name = request.getParameter("name");
        List<User> list = us.search(name);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        response.getWriter().print(s);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
