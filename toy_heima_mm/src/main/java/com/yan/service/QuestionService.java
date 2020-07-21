package com.yan.service;

import com.yan.constants.Constants;
import com.yan.dao.QuestionDao;
import com.yan.dao.QuestionItemDao;
import com.yan.dao.TagDao;
import com.yan.entity.QueryPageBean;
import com.yan.pojo.*;
import com.yan.utils.DateUtils;
import com.yan.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class QuestionService {
    public List<Question> findListByPage(QueryPageBean qb) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        QuestionDao dao = sqlSession.getMapper(QuestionDao.class);
        List<Question> list = dao.findListByPage(qb);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return list;
    }

    public Long findCount(QueryPageBean qb) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        QuestionDao dao = sqlSession.getMapper(QuestionDao.class);
        Long l = dao.findCount(qb);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return l;
    }

    public boolean save(Question question) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            if (question.getId() == 0) {
//                新增
                question.setStatus(Constants.QUESTION_PRE_PUBLISH);
                question.setReviewStatus(Constants.QUESTION_PRE_REVIEW);
                question.setCreateDate(DateUtils.parseDate2String(new Date()));
                QuestionDao dao1 = sqlSession.getMapper(QuestionDao.class);
                dao1.add(question);
                List<QuestionItem> itemList = question.getQuestionItemList();
                if (itemList != null && itemList.size() > 0) {
                    QuestionItemDao dao2 = sqlSession.getMapper(QuestionItemDao.class);
                    for (QuestionItem item : itemList) {
                        if (item == null) {
                            continue;
                        }
                        item.setQuestionId(question.getId());
                        dao2.add(item);
                    }
                }
                List<Tag> tagList = question.getTagList();
                if (tagList != null && tagList.size() > 0) {
                    Map <String,Integer>map = new HashMap();
                    TagDao dao3 = sqlSession.getMapper(TagDao.class);
                    for (Tag tag : tagList) {
                        map.put("questionId", question.getId());
                        map.put("tagId", tag.getId());
                        dao3.add(map);
                    }
                }
            }else {
//                修改
            }
            SqlSessionFactoryUtils.commitAndClose(sqlSession);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            SqlSessionFactoryUtils.rollbackAndClose(sqlSession);
            return false;
        }
    }

    public Long findClassicCount(QueryPageBean qb) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        QuestionDao dao = sqlSession.getMapper(QuestionDao.class);
        Long l = dao.findClassicCount(qb);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return l;
    }

    public List<Question> findClassicListByPage(QueryPageBean qb) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        QuestionDao dao = sqlSession.getMapper(QuestionDao.class);
        List<Question> list = dao.findClassicListByPage(qb);
        if (list != null && list.size() > 0) {
            for (Question question : list) {
                if (question.getReviewLog() == null){
                    question.setReviewLog(new ReviewLog());
                    question.getReviewLog().setStatus(0);
                }
            }
        }
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return list;
    }
}
