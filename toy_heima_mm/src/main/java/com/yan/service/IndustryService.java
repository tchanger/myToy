package com.yan.service;

import com.yan.dao.IndustryDao;
import com.yan.pojo.Industry;
import com.yan.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class IndustryService {
    public List<Industry> findIndustryList() throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        IndustryDao dao = sqlSession.getMapper(IndustryDao.class);
        List<Industry> list = dao.findIndustryList();
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return list;
    }
}
