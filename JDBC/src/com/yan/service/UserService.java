package com.yan.service;

import com.yan.dao.UserDao;
import com.yan.pojo.User;

import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class UserService {
    private UserDao userDao = new UserDao();

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void add(User user) {
        userDao.add(user);
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public User findPage(int id) {
        return userDao.findPage(id);
    }
}
