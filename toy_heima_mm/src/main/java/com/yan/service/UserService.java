package com.yan.service;

import com.yan.dao.UserLoginDao;
import com.yan.pojo.User;
import com.yan.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class UserService {
    public User login(User user) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        UserLoginDao dao = sqlSession.getMapper(UserLoginDao.class);
        User u = dao.login(user);
        if (u != null) {
            u.setAuthorityList(dao.getRole(u));
        }
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return u;
    }
}
