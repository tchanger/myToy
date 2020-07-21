package com.yan.web;

import com.yan.pojo.User;
import com.yan.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/linkMan")
public class LinkManServlet extends HttpServlet {
    private UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodStr = request.getParameter("method");
        if ("findAll".equals(methodStr)){
            findAll(request, response);
        }else if ("add".equals(methodStr)){
            add(request, response);
        }else if ("delete".equals(methodStr)){
            delete(request, response);
        }else if ("update".equals(methodStr)){
            update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = new User();
            Map<String, String[]> parameterMap = request.getParameterMap();
            BeanUtils.populate(user,parameterMap);
            userService.update(user);
            response.sendRedirect("/linkMan?method=findAll");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.delete(id);
        response.sendRedirect("/linkMan?method=findAll");
    }

    private void add(HttpServletRequest request, HttpServletResponse response){
        try {
            User user = new User();
            Map<String, String[]> parameterMap = request.getParameterMap();
            BeanUtils.populate(user,parameterMap);
            System.out.println(user);
            userService.add(user);
            response.sendRedirect("/linkMan?method=findAll");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list = userService.findAll();
        request.setAttribute("users",list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
