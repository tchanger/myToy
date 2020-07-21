package com.yan.web;

import com.yan.bean.LinkMan;
import com.yan.service.LinkManService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/LinkManAdd")
public class LinkManAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Map<String, String[]> map = request.getParameterMap();
            LinkMan linkMan = new LinkMan();
            BeanUtils.populate(linkMan,map);
            LinkManService lms = new LinkManService();
            lms.add(linkMan);
            request.getRequestDispatcher("/LinkManQueryAll").forward(request,response);
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
