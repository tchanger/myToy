package com.yan.web;

import com.yan.anno.Controller;
import com.yan.anno.ResultMapping;
import com.yan.entity.PageResult;
import com.yan.entity.QueryPageBean;
import com.yan.entity.Result;
import com.yan.pojo.Catalog;
import com.yan.pojo.Course;
import com.yan.pojo.User;
import com.yan.service.CourseService;
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
@Controller
@SuppressWarnings("all")
public class CourseController {

    CourseService cs = new CourseService();

    @ResultMapping("/course/findCourseList")
    public void findCourseList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Course> list = cs.findCourseList();
            JsonUtils.printResult(response,new Result(true,"获取成功",list));
        }catch (Exception e){
            JsonUtils.printResult(response,new Result(false,"获取失败"));
        }
    }
    @ResultMapping("/course/findListByPage")
    public void findListByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            QueryPageBean qb = JsonUtils.parseJSON2Object(request, QueryPageBean.class);
            qb.setOffset(qb.getOffset());
            List<Course> list = cs.findListByPage(qb);
            Long l = cs.findCount(qb);
            JsonUtils.printResult(response,new Result(true,"查询成功",new PageResult(l,list)));
        }catch (Exception e){
            JsonUtils.printResult(response,new Result(false,"获取失败"));
        }
    }
    @ResultMapping("/course/add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Course course = JsonUtils.parseJSON2Object(request, Course.class);
            course.setCreateDate(DateUtils.parseDate2String(new Date()));
            User user = (User) request.getSession().getAttribute("user");
            course.setUserId(user.getId());
            course.setCreator(user.getUsername());
            cs.add(course);
            JsonUtils.printResult(response,new Result(true,"添加成功"));
        }catch (Exception e){
            JsonUtils.printResult(response,new Result(false,"添加失败"));
        }
    }
    @ResultMapping("/course/update")
    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Course course = JsonUtils.parseJSON2Object(request, Course.class);
            System.out.println(course);
            cs.update(course);
            JsonUtils.printResult(response,new Result(true,"修改成功"));
        } catch (Exception e) {
            e.printStackTrace();
            JsonUtils.printResult(response,new Result(false,"修改成功"));
        }
    }
    @ResultMapping("/course/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Course course = JsonUtils.parseJSON2Object(request, Course.class);
            if ((course.getCatalogQty() + course.getQuestionQty() + course.getTagQty()) == 0 ){
                cs.delete(course);
                JsonUtils.printResult(response,new Result(true,"删除成功"));
            }else {
                JsonUtils.printResult(response,new Result(false,"该数据不能删除！"));
            }
        }catch (Exception e){
            JsonUtils.printResult(response,new Result(false,"删除失败！"));
        }
    }
}
