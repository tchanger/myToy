package com.yan.web;

import com.yan.bean.PageBean;
import com.yan.bean.User;
import com.yan.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @Author:yan
 * @Todo
 **/
@WebServlet("/linkMan")
@SuppressWarnings("all")
public class userController extends UserServlet {
    public void update(HttpServletRequest request, HttpServletResponse response, UserService us) throws IOException {
        try {
            int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            int pageSize = Integer.parseInt(request.getParameter("pageSize"));
            User user = new User();
            Map<String, String[]> parameterMap = request.getParameterMap();
            BeanUtils.populate(user,parameterMap);
            us.update(user);
            response.sendRedirect("linkMan?method=pageQuery&pageNumber=" + pageNumber +"&pageSize=" + pageSize);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void findPage(HttpServletRequest request, HttpServletResponse response, UserService us) throws ServletException, IOException {
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int id = Integer.parseInt(request.getParameter("id"));
        User user = us.findPage(id);
        request.setAttribute("user",user);
        request.getRequestDispatcher("/update.jsp?pageNumber=" + pageNumber +"&pageSize=" + pageSize).forward(request,response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response, UserService us) throws IOException {
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int id = Integer.parseInt(request.getParameter("id"));
        us.delete(id);
        response.sendRedirect("linkMan?method=pageQuery&pageNumber=" + pageNumber +"&pageSize=" + pageSize);
//        response.sendRedirect("/linkMan?method=findAll");
    }

    public void add(HttpServletRequest request, HttpServletResponse response, UserService us) throws ServletException, IOException {
        try {
            Map<String, String[]> map = request.getParameterMap();
            User user = new User();
            BeanUtils.populate(user,map);
            us.add(user);
            response.sendRedirect("/linkMan?method=pageQuery&pageNumber=1&pageSize=10");
//            response.sendRedirect("/linkMan?method=findAll");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void findAll(HttpServletRequest request, HttpServletResponse response, UserService us) throws ServletException, IOException {
        List<User> list = us.findAll();
        request.setAttribute("users",list);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    public void pageQuery(HttpServletRequest request, HttpServletResponse response, UserService us) throws ServletException, IOException {
        int pageNumber = 1;
        String pageNumberStr = request.getParameter("pageNumber");
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        if (pageNumberStr != null) {
            pageNumber = Integer.parseInt(pageNumberStr);
        }
        PageBean<User> pageBean = us.pageQuery(pageNumber, pageSize);
        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("/list_page.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
