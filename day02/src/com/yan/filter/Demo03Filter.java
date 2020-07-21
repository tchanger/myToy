package com.yan.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:yan
 * 屏蔽关键字的过滤器
 **/
@SuppressWarnings("all")
@WebFilter({"/demo01.jsp","/Demo01Servlet"})
public class Demo03Filter implements Filter {
    List<String> list = new ArrayList();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(filterConfig.getServletContext().getResourceAsStream("WEB-INF/word.txt"),"utf-8"))) {
            String line = null;
            while ((line = br.readLine()) != null){
                list.add(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequest requestProxy = (ServletRequest) Proxy.newProxyInstance(
                request.getClass().getClassLoader(),
                request.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if ("getParameter".equals(method.getName())){
                            String s = (String) method.invoke(request,args);
                            for (String s1 : list) {
                                s = s.replace(s1,"**");
                            }
                            return s;
                        }
                        return method.invoke(request,args);
                    }
                }
        );
        chain.doFilter(requestProxy,response);
    }

    @Override
    public void destroy() {

    }
}
