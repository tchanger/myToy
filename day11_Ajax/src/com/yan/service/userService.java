package com.yan.service;

import com.yan.bean.User;
import com.yan.dao.userDao;
import com.yan.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class userService {
    public boolean check(String username) throws IOException {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        userDao dao = sqlSession.getMapper(userDao.class);
        User user = dao.check(username);
        MybatisUtils.commitAndClose(sqlSession);
        return user != null;
    }

    public List<User> search(String name) throws IOException {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        userDao dao = sqlSession.getMapper(userDao.class);
        List<User> list = dao.search(name);
        MybatisUtils.commitAndClose(sqlSession);
        return list;
    }
}
