package com.yan.dao;

import com.yan.pojo.ReviewLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface ReviewLogDao {

    ReviewLog findByQuestion(Integer id);

    @Insert("insert into t_review_log (comments,status,question_id,user_id,create_date) values (#{comments},#{status},#{questionId},#{userId},#{createDate})")
    void review(ReviewLog reviewLog);
}
