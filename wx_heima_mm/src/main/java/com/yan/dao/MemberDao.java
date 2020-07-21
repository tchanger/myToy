package com.yan.dao;

import com.yan.pojo.WxMember;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public interface MemberDao {

    WxMember findWxMember(String openId);

    void register(WxMember member);


    void setCityAndCourse(HashMap<String, String> map);
}
