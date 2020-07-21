package com.yan.web;

import com.yan.anno.Controller;
import com.yan.anno.ResultMapping;
import com.yan.dao.UserLoginDao;
import com.yan.entity.Result;
import com.yan.pojo.User;
import com.yan.service.UserService;
import com.yan.utils.JsonUtils;
import com.yan.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
@Controller
public class UserController {
    UserService us = new UserService();
    @ResultMapping("/user/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            User user = JsonUtils.parseJSON2Object(request, User.class);
            User user2 = us.login(user);
            if (user2 != null) {
                request.getSession().setAttribute("user",user2);
                JsonUtils.printResult(response,new Result(true,"登录成功"));
            }
        } catch (IOException e) {
            e.printStackTrace();
            JsonUtils.printResult(response,new Result(false,"登录失败"));
        }
    }
    @ResultMapping("/user/loginOut")
    public void loginOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.getSession().removeAttribute("user");
            JsonUtils.printResult(response,new Result(true,"退出成功"));
        }catch (Exception e){
            e.printStackTrace();
            JsonUtils.printResult(response,new Result(false,"退出失败"));
        }
    }
}
