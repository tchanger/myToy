package com.yan.service;

import com.yan.dao.QuestionDao;
import com.yan.dao.ReviewLogDao;
import com.yan.pojo.ReviewLog;
import com.yan.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class ReviewLogService {
    public boolean review(ReviewLog reviewLog) {
        SqlSession session = null;
        try {
            session = SqlSessionFactoryUtils.openSqlSession();
            ReviewLogDao reviewLogDao = session.getMapper(ReviewLogDao.class);
            reviewLogDao.review(reviewLog);
            QuestionDao questionDao = session.getMapper(QuestionDao.class);
            questionDao.updateReview(reviewLog);
            SqlSessionFactoryUtils.commitAndClose(session);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            SqlSessionFactoryUtils.rollbackAndClose(session);
            return false;
        }
    }
}
