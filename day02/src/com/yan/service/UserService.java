package com.yan.service;

import com.yan.bean.User;
import com.yan.dao.UserDao;

import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class UserService {
    UserDao userDao = new UserDao();
    public List<User> findAll() {
        return userDao.findAll();
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public boolean add(User user) {
        return userDao.add(user);
    }

    public User findOne(int id) {
        return userDao.findOne(id);
    }
}
