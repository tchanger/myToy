package com.yan.web;

import com.yan.anno.Controller;
import com.yan.anno.ResultMapping;
import com.yan.entity.PageResult;
import com.yan.entity.QueryPageBean;
import com.yan.entity.Result;
import com.yan.pojo.Catalog;
import com.yan.pojo.Question;
import com.yan.pojo.User;
import com.yan.service.CatalogService;
import com.yan.utils.DateUtils;
import com.yan.utils.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
@Controller
public class CatalogController {
    CatalogService cs = new CatalogService();
    @ResultMapping("/catalog/findListByPage")
    public void findListByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            QueryPageBean qb = JsonUtils.parseJSON2Object(request, QueryPageBean.class);
            qb.setOffset(qb.getOffset());
            PageResult pr = cs.findListByPage(qb);
            JsonUtils.printResult(response,new Result(true,"查询成功",pr));
        } catch (Exception e) {
            e.printStackTrace();
            JsonUtils.printResult(response,new Result(false,"查询失败"));
        }
    }
    @ResultMapping("/catalog/add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            User uesr = (User) request.getSession().getAttribute("user");
            Catalog catalog = JsonUtils.parseJSON2Object(request,Catalog.class);
            catalog.setCreateDate(DateUtils.parseDate2String(new Date()));
            catalog.setStatus(0);
            catalog.setUserId(uesr.getId());
            catalog.setCreator(uesr.getUsername());
            catalog.setOrderNo(1);
            catalog.setQuestionQty(0);
            cs.add(catalog);
            JsonUtils.printResult(response,new Result(true,"添加目录成功"));
        }catch (Exception e){
            JsonUtils.printResult(response,new Result(false,"添加目录失败"));
        }
    }
    @ResultMapping("/catalog/updateName")
    public void updateName(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
            Catalog catalog = JsonUtils.parseJSON2Object(request,Catalog.class);
            cs.updateName(catalog);
            JsonUtils.printResult(response,new Result(true,"修改成功！"));
        }catch (Exception e){
            JsonUtils.printResult(response,new Result(false,"修改失败！"));
        }
    }
    @ResultMapping("/catalog/updateStatus")
    public void updateStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try{
            Catalog catalog = JsonUtils.parseJSON2Object(request, Catalog.class);
            cs.updateStatus(catalog);
            JsonUtils.printResult(response,new Result(true,"禁用成功！"));
        }catch (Exception e){
            JsonUtils.printResult(response,new Result(false,"禁用失败！"));
        }
    }

    @ResultMapping("/catalog/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            Catalog catalog = JsonUtils.parseJSON2Object(request, Catalog.class);
            cs.delete(catalog.getId());
            JsonUtils.printResult(response,new Result(true,"删除成功！"));
        }catch (Exception e){
            JsonUtils.printResult(response,new Result(false,"删除失败！"));
        }
    }
}
