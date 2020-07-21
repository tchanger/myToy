package com.yan.dao;

import com.yan.pojo.Course;
import com.yan.pojo.Dict;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommonDao {

    Dict findDict(String value);

    @Select("select id,data_value title from t_dict where data_tag = #{value}")
    List<Dict> findList(Integer value);

    @Select("select icon,id,name title from t_course")
    List<Course> findCourses();

}
