package com.yan.dao;

import com.yan.bean.LinkMan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LinkManDao {

    List<LinkMan> queryAll();

    @Insert("insert into linkman (name,sex,age,address,qq,email) values (#{name},#{sex},#{age},#{address},#{qq},#{email})")
    void add(LinkMan linkMan);

    @Select("select * from linkman where id = #{id}")
    LinkMan findById(int id);

    void edit(LinkMan lm);

    @Delete("delete from linkman where id = #{id}")
    void delete(int id);
}
