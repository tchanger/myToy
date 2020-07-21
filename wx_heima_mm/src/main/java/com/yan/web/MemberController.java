package com.yan.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.yan.anno.Controller;
import com.yan.anno.ResultMapping;
import com.yan.pojo.User;
import com.yan.pojo.WxMember;
import com.yan.service.MemberService;
import com.yan.utils.DateUtils;
import com.yan.utils.JsonUtils;
import com.yan.utils.WxUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

/**
 * @Author:yan
 * @Todo
 **/
@Controller
@SuppressWarnings("all")
public class MemberController {
    MemberService ms = new MemberService();
    @ResultMapping("/member/login")
    public void userLogin (HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            HashMap params = JsonUtils.parseJSON2Object(request, HashMap.class);
            String code = (String) params.get("code");
            JSONObject jsonObject = WxUtil.get(code);
            String openId = jsonObject.getString("openid");
            WxMember member = ms.findWxMember(openId);
            if (member == null) {
                String key = jsonObject.getString("session_key");
                JSONObject info = WxUtil.getUserInfo((String) params.get("encryptedData"), key, (String) params.get("iv"));
                member = info.toJavaObject(WxMember.class);
                member.setCreateTime(DateUtils.parseDate2String(new Date()));
                ms.register(member);
            }
            HashMap<String,Object> result = new HashMap();
            result.put("token",openId);
            result.put("userInfo",member);
            JsonUtils.printResult(response,result);
        }catch (Exception e){

        }
    }

    @ResultMapping("/member/setCityAndCourse")
    public void setCityAndCourse(HttpServletRequest request, HttpServletResponse response){
        try {
            HashMap<String,String> map = JsonUtils.parseJSON2Object(request, HashMap.class);

            String openId = request.getHeader("Authorization");
            openId = openId.substring(7);
            map.put("openId", openId);

            ms.setCityAndCourse(map);
            JsonUtils.printResult(response, "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
