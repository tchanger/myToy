package com.yan.web;

import com.yan.bean.User;
import com.yan.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserService userService = new UserService();
            User user = new User();
            Map<String, String[]> map = request.getParameterMap();
            BeanUtils.populate(user,map);
            if (userService.add(user)){
                request.setAttribute("message","添加成功！");
            }else {
                request.setAttribute("message","添加失败！");
            }
            response.sendRedirect("findAll");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
