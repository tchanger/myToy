package com.yan.dao;

import com.yan.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserLoginDao {

    User login(User user);

    @Select("SELECT keyword FROM t_role WHERE id = ( SELECT role_id FROM tr_user_role where user_id = #{id} )")
    List<String> getRole(User user);
}
