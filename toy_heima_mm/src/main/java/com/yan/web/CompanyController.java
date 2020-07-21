package com.yan.web;

import com.yan.anno.Controller;
import com.yan.anno.ResultMapping;
import com.yan.entity.Result;
import com.yan.pojo.Company;
import com.yan.pojo.Course;
import com.yan.service.CompanyService;
import com.yan.utils.JedisUtils;
import com.yan.utils.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
@Controller
public class CompanyController {
    CompanyService cs = new CompanyService();
    @ResultMapping("/company/findCompanyList")
    public void findCompanyList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Company> list = cs.findCompanyList();
            JsonUtils.printResult(response,new Result(true,"获取成功",list));
        }catch (Exception e){
            e.printStackTrace();
            JsonUtils.printResult(response,new Result(false,"加载企业列表失败"));
        }
    }
}
