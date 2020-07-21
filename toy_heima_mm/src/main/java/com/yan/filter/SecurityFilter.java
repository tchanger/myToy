package com.yan.filter;

import com.yan.pojo.User;
import com.yan.util.ClassScannerUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jaxen.JaxenException;
import org.jaxen.dom4j.Dom4jXPath;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class SecurityFilter implements Filter {
    Map<String,String> map = new HashMap();
    public void init(FilterConfig config) throws ServletException {
        try(InputStream is = this.getClass().getClassLoader().getResourceAsStream(config.getInitParameter("configLocation"))) {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(is);
            List<Element> list = document.selectNodes("//security");
            for (Element element : list) {
                String path = element.attributeValue("pattern");
                String hasRole = element.attributeValue("has_role");
                //保存到pathMap中
                map.put(path, hasRole);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String uri = request.getRequestURI();
        if (uri.endsWith(".do")){
            uri = uri.replace(".do","");
        }
        String path = uri.substring(request.getContextPath().length());
        String s = map.get(path);
        User user = (User) request.getSession().getAttribute("user");
        if (s != null) {
            //获取不到登录用户，跳转至登录页面
            if (user == null) {
                response.sendRedirect("localhost:8080/login.html");
                return;
            }
            String[] split = s.split(",");
            for (String s1 : split) {
                if (user.getAuthorityList().contains(s1)){
                    chain.doFilter(request, response);
                    return;
                }
            }
            response.getWriter().print("权限不足");
        }else {
            chain.doFilter(request, response);
            return;
        }
    }

    public void destroy() {
    }

}
