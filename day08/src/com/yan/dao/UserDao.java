package com.yan.dao;

import com.yan.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    List<User> queryAllList();
    User findById(int uid);

    List<User> serch1(String s);

    @Select("select * from user where username like #{username}")
    List<User> serch2(String s);

    void save(User user);

    @Delete("delete from user where id = #{id}")
    void delete(int i);

    void edit(User user);
}
