package com.yan.service;

import com.yan.bean.User;

public interface UserService {
    void save();

    User findById(Integer id);
}
