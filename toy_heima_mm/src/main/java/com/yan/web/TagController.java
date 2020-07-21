package com.yan.web;

import com.yan.anno.Controller;
import com.yan.anno.ResultMapping;
import com.yan.entity.PageResult;
import com.yan.entity.QueryPageBean;
import com.yan.entity.Result;
import com.yan.service.TagService;
import com.yan.utils.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:yan
 * @Todo
 **/
@Controller
@SuppressWarnings("all")
public class TagController {
    TagService ts = new TagService();
    @ResultMapping("/tag/findListByPage")
    public void findListByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            QueryPageBean qb = JsonUtils.parseJSON2Object(request, QueryPageBean.class);
            qb.setOffset(qb.getOffset());
            PageResult pr = ts.findListByPage(qb);
            JsonUtils.printResult(response,new Result(true,"查询成功！",pr));
        } catch (Exception e) {
            e.printStackTrace();
            JsonUtils.printResult(response,new Result(false,"查询失败！"));
        }

    }
}
