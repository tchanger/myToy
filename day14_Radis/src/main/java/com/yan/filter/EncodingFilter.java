package com.yan.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author liuyp
 * @date 2020/02/11
 */
@WebFilter("/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //解决请求中文乱码
        request.setCharacterEncoding("utf-8");
        //解决响应中文乱码
        response.setContentType("text/html;charset=utf-8");

        //放行请求
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
