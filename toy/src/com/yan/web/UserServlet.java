package com.yan.web;

import com.yan.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
@SuppressWarnings("all")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserService us = new UserService();
           /* String method = request.getParameter("method");
            if ("findAll".equals(method)){
                findAll(request, response, us);
            }else if ("add".equals(method)){
                add(request, response, us);
            }else if ("findPage".equals(method)){
                findPage(request, response, us);
            }else if ("delete".equals(method)){
                delete(request, response, us);
            }else if ("update".equals(method)){
                update(request, response, us);
            }*/
            String methodStr = request.getParameter("method");
            Class clazz = this.getClass();
            Method method = clazz.getMethod(methodStr, HttpServletRequest.class, HttpServletResponse.class, UserService.class);
            method.invoke(this,request,response,us);
//            Method[] methods = clazz.getMethods();
//            for (Method method : methods) {
//                if (methodStr.equalsIgnoreCase(method.getName())){
//                    method.invoke(this,request,response,us);
//                    break;
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
