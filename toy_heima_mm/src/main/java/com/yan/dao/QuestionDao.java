package com.yan.dao;

import com.yan.entity.QueryPageBean;
import com.yan.pojo.Catalog;
import com.yan.pojo.Question;
import com.yan.pojo.ReviewLog;
import com.yan.pojo.Tag;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public interface QuestionDao {

    public List<Question> findListByPage(QueryPageBean qb);

    Long findCount(QueryPageBean qb);

    void add(Question question);

    Long findClassicCount(QueryPageBean qb);

    List<Question> findClassicListByPage(QueryPageBean qb);

    @Update("update t_question set status = #{status} where id = #{questionId}")
    void updateReview(ReviewLog reviewLog);
}
