package com.yan.service;

import com.yan.bean.User;
import com.yan.dao.UserDao;
import com.yan.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import java.io.IOException;
import java.util.List;


/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class UserService {
    public boolean login(User user) throws IOException {
        SqlSession session = MybatisUtils.openSqlSession();
        UserDao dao = session.getMapper(UserDao.class);
        User user2 = dao.login(user);
        MybatisUtils.commitAndClose(session);
        if (user2 == null) {
            return false;
        }
        return true;
    }
}
