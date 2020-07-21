package com.yan.service.impl;

import com.yan.dao.UserDao;
import com.yan.service.UserService;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class UserServiceImpl implements UserService {
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    UserDao userDao;

    public void save() {
        userDao.save();
        System.out.println("UserService...");
    }
}
