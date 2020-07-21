package com.yan.web;

import com.alibaba.fastjson.JSON;
import com.yan.anno.Controller;
import com.yan.anno.ResultMapping;
import com.yan.pojo.Course;
import com.yan.pojo.Dict;
import com.yan.service.CommonService;
import com.yan.utils.JedisUtils;
import com.yan.utils.JsonUtils;
import com.yan.utils.LocationUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
@Controller
public class CommonController {
    CommonService cs = new CommonService();


    @ResultMapping("/common/cities")
    public void findCities (HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            HashMap map = JsonUtils.parseJSON2Object(request, HashMap.class);
            Map result = cs.findCities(map);
            JsonUtils.printResult(response,result);
        } catch (Exception e) {
            e.printStackTrace();
            JsonUtils.printResult(response,null);
        }
    }
    @ResultMapping("/common/courses")
    public void findCourses (HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String cources = JedisUtils.get("course");
            if (cources == null || "".equals(cources)) {
                List<Course> list = cs.findCourses();
                cources = JSON.toJSONString(list);
                JedisUtils.set("course",cources);
            }
            Object parse = JSON.parse(cources);
            JsonUtils.printResult(response,parse);
        }catch (Exception e){
            JsonUtils.printResult(response,null);
        }

    }


}