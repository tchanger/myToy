package com.yan.web;

import com.yan.anno.Controller;
import com.yan.anno.ResultMapping;
import com.yan.entity.PageResult;
import com.yan.entity.QueryPageBean;
import com.yan.entity.Result;
import com.yan.pojo.*;
import com.yan.service.QuestionService;
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
public class QuestionConller {
    QuestionService questionService = new QuestionService();

    @ResultMapping("/question/findListByPage")
    public void findListByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            QueryPageBean qb = JsonUtils.parseJSON2Object(request, QueryPageBean.class);
            qb.setOffset(qb.getOffset());
            Long l = questionService.findCount(qb);
            List<Question> list = questionService.findListByPage(qb);
            JsonUtils.printResult(response,new Result(true,"查询成功",new PageResult(l,list)));
        } catch (Exception e) {
            e.printStackTrace();
            JsonUtils.printResult(response,new Result(false,"查询失败"));
        }
    }
    @ResultMapping("/question/save")
    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Question question = JsonUtils.parseJSON2Object(request, Question.class);
        User user = (User) request.getSession().getAttribute("user");
        question.setUserId(user.getId());
        boolean save = questionService.save(question);
        if (save){
            JsonUtils.printResult(response,new Result(true,"操作成功！"));
        }else {
            JsonUtils.printResult(response,new Result(false,"操作失败！"));
        }
    }
    @ResultMapping("/question/findClassicListByPage")
    public void findClassicListByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            QueryPageBean qb = JsonUtils.parseJSON2Object(request, QueryPageBean.class);
            qb.setOffset(qb.getOffset());
            Long l = questionService.findClassicCount(qb);
            List<Question> list = questionService.findClassicListByPage(qb);
            JsonUtils.printResult(response,new Result(true,"查询成功",new PageResult(l,list)));
        } catch (Exception e) {
            e.printStackTrace();
            JsonUtils.printResult(response,new Result(false,"查询失败"));
        }
    }
}
