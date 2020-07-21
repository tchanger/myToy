package com.yan.dao;

import com.yan.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    void update(User user);

    User findPage(int id);

    void delete(int id);

    void add(User user);

    @Select("select count(*) from linkman")
    int totalCount();

    @Select("select * from linkman limit #{arg0},#{arg1}")
    List<User> pageQuery(int startIndex, int pageSize);
}
