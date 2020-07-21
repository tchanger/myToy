package com.yan.dao;

import com.yan.bean.Linkman;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LinkmanDao {

    @Select("select * from linkman")
    List<Linkman> queryAll();

    void add(Linkman linkman);

    @Delete("delete from linkman where id = #{id}")
    void delete(int id);

    @Select("select * from linkman where id = #{id}")
    Linkman findById(int id);

    void update(Linkman lk);
}
