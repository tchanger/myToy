package com.yan.dao;

import com.yan.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface userDao {

    @Select("select * from user where name = #{username}")
    User check(String username);

    List<User> search(String name);
}
