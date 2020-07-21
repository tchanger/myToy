package com.yan.service.impl;

import com.yan.bean.User;
import com.yan.dao.UserDao;
import com.yan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:yan
 * @Todo
 **/
@Service("userService")
@SuppressWarnings("all")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    public void save() {
        userDao.save();
        System.out.println("UserService....");
    }

    public User findById(Integer id) {
        return userDao.findById(id);
    }
}
