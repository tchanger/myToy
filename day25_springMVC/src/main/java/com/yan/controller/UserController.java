package com.yan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
@Controller
public class UserController {
    @RequestMapping("/aa")
    public String fun(ModelAndView mav){

        System.out.println(111);
        return "success";
    }
}
