package com.yan.service;

import com.yan.dao.TagDao;
import com.yan.entity.PageResult;
import com.yan.entity.QueryPageBean;
import com.yan.pojo.Tag;
import com.yan.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class TagService {

    public PageResult findListByPage(QueryPageBean qb) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        TagDao dao = sqlSession.getMapper(TagDao.class);
        List<Tag>list = dao.findList(qb);
        long l = dao.findCount(qb);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return new PageResult(l,list);
    }
}
