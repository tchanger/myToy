package com.yan.dao;

import com.yan.entity.QueryPageBean;
import com.yan.pojo.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TagDao {

    @Select("select * from t_tag where course_id = #{id}")
    List<Tag> findTagListByCourse(Integer id);


    long findCount(QueryPageBean qb);

    List<Tag> findList(QueryPageBean qb);

    @Insert("insert into tr_question_tag (question_id,tag_id) values (#{questionId},#{tagId})")
    void add(Map<String, Integer> map);

}
