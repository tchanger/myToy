package com.yan.web;

import com.yan.anno.Controller;
import com.yan.anno.ResultMapping;
import com.yan.entity.Result;
import com.yan.pojo.Dict;
import com.yan.service.DictService;
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
public class DictController {
    DictService ds = new DictService();
    @ResultMapping("/dict/findDictList")
    public void findDictList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Dict> list = ds.findDictList();
            JsonUtils.printResult(response,new Result(true,"加载地区下拉列表成功",list));
        }catch (Exception e){
            JsonUtils.printResult(response,new Result(false,"加载地区下拉列表失败"));
        }
    }
}
