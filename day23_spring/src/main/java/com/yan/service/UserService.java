package com.yan.service;

import com.yan.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:yan
 * @Todo
 **/
@Service("userService")
@SuppressWarnings("all")
public class UserService {
//    @Autowired
//    UserDao userDao;

    public void save(){
//        userDao.save();
        System.out.println("....");
    }
}
