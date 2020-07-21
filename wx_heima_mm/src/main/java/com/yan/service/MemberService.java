package com.yan.service;

import com.yan.dao.MemberDao;
import com.yan.pojo.User;
import com.yan.pojo.WxMember;
import com.yan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.HashMap;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class MemberService {
    public WxMember findWxMember(String openId) throws IOException {
        SqlSession session = MybatisUtils.openSqlSession();
        MemberDao dao = session.getMapper(MemberDao.class);
        WxMember wxMember = dao.findWxMember(openId);
        MybatisUtils.commitAndClose(session);
        return wxMember;
    }

    public void register(WxMember member) throws IOException {
        SqlSession session = MybatisUtils.openSqlSession();
        MemberDao dao = session.getMapper(MemberDao.class);
        dao.register(member);
        MybatisUtils.commitAndClose(session);
    }

    public void setCityAndCourse(HashMap<String, String> map) throws IOException {
        SqlSession session = MybatisUtils.openSqlSession();
        MemberDao dao = session.getMapper(MemberDao.class);
        dao.setCityAndCourse(map);
        MybatisUtils.commitAndClose(session);
    }
}
