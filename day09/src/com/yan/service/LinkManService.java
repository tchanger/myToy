package com.yan.service;

import com.yan.bean.LinkMan;
import com.yan.dao.LinkManDao;
import com.yan.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class LinkManService {
    public List<LinkMan> queryAll() throws IOException {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        LinkManDao dao = sqlSession.getMapper(LinkManDao.class);
        List<LinkMan> list = dao.queryAll();
        sqlSession.close();
        return list;
    }

    public void add(LinkMan linkMan) throws IOException {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        try {
            LinkManDao dao = sqlSession.getMapper(LinkManDao.class);
            dao.add(linkMan);
            MybatisUtils.commitAndClose(sqlSession);
        } catch (Exception e) {
            e.printStackTrace();
            MybatisUtils.rollbackAndClose(sqlSession);
        }
    }

    public LinkMan findById(int id) throws IOException {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        LinkManDao dao = sqlSession.getMapper(LinkManDao.class);
        LinkMan lk = dao.findById(id);
        sqlSession.close();
        return lk;
    }

    public void edit(LinkMan lm) throws IOException {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        try {
            LinkManDao dao = sqlSession.getMapper(LinkManDao.class);
            dao.edit(lm);
            MybatisUtils.commitAndClose(sqlSession);
        } catch (Exception e) {
            e.printStackTrace();
            MybatisUtils.rollbackAndClose(sqlSession);
        }
    }

    public void delete(int id) throws IOException {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        try {
            LinkManDao dao = sqlSession.getMapper(LinkManDao.class);
            dao.delete(id);
            MybatisUtils.commitAndClose(sqlSession);
        } catch (Exception e) {
            e.printStackTrace();
            MybatisUtils.rollbackAndClose(sqlSession);
        }
    }
}
