package com.yan.dao;

import com.yan.bean.User;

public interface UserDao {
    void save();

    User findById(Integer id);

}
