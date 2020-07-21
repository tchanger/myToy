package com.yan.dao;

import com.yan.entity.QueryPageBean;
import com.yan.pojo.Catalog;
import com.yan.pojo.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseDao {

    List<Course> findCourseList();


    List<Course> findListByPage(QueryPageBean qb);


    Long findCount(QueryPageBean qb);

    void add(Course course);

    void update(Course course);

    @Delete("delete from t_course where id = #{id}")
    void delete(Course course);
}
