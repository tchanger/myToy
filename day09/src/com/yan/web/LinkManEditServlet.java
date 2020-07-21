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

@WebServlet("/LinkManEdit")
public class LinkManEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            LinkManService lms = new LinkManService();
            LinkMan lm = new LinkMan();
            Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(lm,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        lms.edit(lm);
        response.sendRedirect("/LinkManQueryAll");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
