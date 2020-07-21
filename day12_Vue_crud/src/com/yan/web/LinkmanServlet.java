package com.yan.web;

import com.yan.bean.Linkman;
import com.yan.bean.Result;
import com.yan.service.LinkmanService;
import com.yan.util.JsonUtils;
import com.yan.web.controller.LinkmanController;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@WebServlet("/Linkman")
@SuppressWarnings("all")
public class LinkmanServlet extends LinkmanController {
    public void queryAll(HttpServletRequest request, HttpServletResponse response, LinkmanService ls) throws IOException {
        try {
            List<Linkman> list = ls.queryAll();
            JsonUtils.printResult(response,new Result(true,"获取所有联系人信息成功",list));
        } catch (Exception e) {
            e.printStackTrace();
            JsonUtils.printResult(response,new Result(false,"获取所有联系人失败"));
        }
    }
    public void add (HttpServletRequest request, HttpServletResponse response, LinkmanService ls) throws IOException {
        try {
            Linkman linkman = JsonUtils.parseJSON2Object(request, Linkman.class);
            ls.add(linkman);
            JsonUtils.printResult(response,new Result(true,"添加成功"));
        } catch (IOException e) {
            e.printStackTrace();
            JsonUtils.printResult(response,new Result(false,"添加联系人失败"));
        }
    }
    public void delete (HttpServletRequest request, HttpServletResponse response, LinkmanService ls) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ls.delete(id);
            JsonUtils.printResult(response,new Result(true,"删除成功！"));
        } catch (Exception e) {
            e.printStackTrace();
            JsonUtils.printResult(response,new Result(false,"删除失败！"));
        }
    }
    public void findById (HttpServletRequest request, HttpServletResponse response, LinkmanService ls) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Linkman lk = ls.findById(id);
            JsonUtils.printResult(response,new Result(true,"查询成功",lk));
        } catch (Exception e) {
            e.printStackTrace();
            JsonUtils.printResult(response,new Result(false,"查询失败！"));
        }
    }
    public void update (HttpServletRequest request, HttpServletResponse response, LinkmanService ls) throws IOException {
        try {
            Linkman lk = JsonUtils.parseJSON2Object(request, Linkman.class);
            ls.update(lk);
            JsonUtils.printResult(response,new Result(true,"修改成功！"));
        } catch (Exception e) {
            e.printStackTrace();
            JsonUtils.printResult(response,new Result(false,"修改失败！"));
        }
    }
}
