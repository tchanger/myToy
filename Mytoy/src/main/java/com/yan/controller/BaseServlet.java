package com.yan.controller;

import com.yan.anno.Controller;
import com.yan.anno.ResultMapping;
import com.yan.bean.MetObj;
import com.yan.util.ClassScannerUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("*.do")
@SuppressWarnings("all")
public class BaseServlet extends HttpServlet {
    private static Map<String, MetObj> map = new HashMap<>();
    static {
        try {
            List<Class<?>> list = ClassScannerUtils.getClasssFromPackage("com.yan.web");
            for (Class<?> clazz : list) {
                if (!clazz.isAnnotationPresent(Controller.class)) {
                    continue;
                }
                Object o = clazz.newInstance();
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(ResultMapping.class)) {
                        map.put(method.getAnnotation(ResultMapping.class).value(),new MetObj(method,o));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String uri = request.getRequestURI();
            String contextPath = request.getContextPath();
            String path = uri.substring(contextPath.length(), uri.lastIndexOf("."));
            MetObj metObj = map.get(path);
            metObj.getMethod().invoke(metObj.getObj(),request,response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
