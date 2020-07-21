package com.yan.dao.impl;

import com.yan.bean.User;
import com.yan.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Author:yan
 * @Todo
 **/
@Repository
@SuppressWarnings("all")
public class UserDaoImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void save() {
        System.out.println("UserDao....");
    }

    public User findById(Integer id) {
        User user = jdbcTemplate.queryForObject("select * from user where id = ?", new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }
}
