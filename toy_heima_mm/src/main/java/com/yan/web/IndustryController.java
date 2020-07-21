package com.yan.web;

import com.yan.anno.Controller;
import com.yan.anno.ResultMapping;
import com.yan.entity.Result;
import com.yan.pojo.Industry;
import com.yan.service.IndustryService;
import com.yan.utils.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@Controller
@SuppressWarnings("all")
public class IndustryController {
    IndustryService is = new IndustryService();
    @ResultMapping("/industry/findIndustryList")
    public void findIndustryList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Industry> list = is.findIndustryList();
            JsonUtils.printResult(response,new Result(true,"加载方向下拉列表成功",list));
        }catch (Exception e){
            JsonUtils.printResult(response,new Result(false,"加载方向下拉列表失败"));
        }
    }
}
