package com.yan.web;

import com.yan.anno.Controller;
import com.yan.anno.ResultMapping;
import com.yan.entity.Result;
import com.yan.pojo.ReviewLog;
import com.yan.pojo.User;
import com.yan.service.ReviewLogService;
import com.yan.utils.DateUtils;
import com.yan.utils.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
@Controller
public class ReviewController {
    ReviewLogService rs = new ReviewLogService();
    @ResultMapping("/review/review")
    public void review(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ReviewLog reviewLog = JsonUtils.parseJSON2Object(request, ReviewLog.class);
        User user = (User) request.getSession().getAttribute("user");
        reviewLog.setUserId(user.getId());
        reviewLog.setCreateDate(DateUtils.parseDate2String(new Date()));
        boolean b = rs.review(reviewLog);
        JsonUtils.printResult(response,new Result(b,b ? "操作成功":"操作失败"));
    }
}
