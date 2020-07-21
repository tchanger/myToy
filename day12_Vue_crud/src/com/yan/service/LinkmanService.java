package com.yan.service;

import com.yan.bean.Linkman;
import com.yan.dao.LinkmanDao;
import com.yan.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class LinkmanService {
    public List<Linkman> queryAll() throws IOException {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        LinkmanDao dao = sqlSession.getMapper(LinkmanDao.class);
        List<Linkman> list = dao.queryAll();
        MybatisUtils.commitAndClose(sqlSession);
        return list;
    }

    public void add(Linkman linkman) throws IOException {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        LinkmanDao dao = sqlSession.getMapper(LinkmanDao.class);
        dao.add(linkman);
        MybatisUtils.commitAndClose(sqlSession);
    }

    public void delete(int id) throws IOException {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        LinkmanDao dao = sqlSession.getMapper(LinkmanDao.class);
        dao.delete(id);
        MybatisUtils.commitAndClose(sqlSession);
    }

    public Linkman findById(int id) throws IOException {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        LinkmanDao dao = sqlSession.getMapper(LinkmanDao.class);
        Linkman lk = dao.findById(id);
        MybatisUtils.commitAndClose(sqlSession);
        return lk;
    }

    public void update(Linkman lk) throws IOException {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        LinkmanDao dao = sqlSession.getMapper(LinkmanDao.class);
        dao.update(lk);
        MybatisUtils.commitAndClose(sqlSession);
    }
}
