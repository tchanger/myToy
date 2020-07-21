package com.yan.web;

import com.yan.anno.Controller;
import com.yan.anno.ResultMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
@Controller
public class web {
    @ResultMapping("/aa/toy")
    public void add(HttpServletRequest request, HttpServletResponse response){
        System.out.println(1111);
        System.out.println(request.getRequestURI());///aa/toy.do
        System.out.println(request.getRequestURL());//http://localhost:8080/aa/toy.do
    }
}
