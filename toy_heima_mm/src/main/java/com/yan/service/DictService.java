package com.yan.service;

import com.yan.dao.DictDao;
import com.yan.pojo.Dict;
import com.yan.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class DictService {
    public List<Dict> findDictList() throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        DictDao dao = sqlSession.getMapper(DictDao.class);
        List<Dict> list = dao.findDictList();
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return list;
    }
}
