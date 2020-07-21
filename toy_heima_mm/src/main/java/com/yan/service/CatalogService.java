package com.yan.service;

import com.yan.dao.CatalogDao;
import com.yan.dao.QuestionDao;
import com.yan.entity.PageResult;
import com.yan.entity.QueryPageBean;
import com.yan.pojo.Catalog;
import com.yan.pojo.Question;
import com.yan.pojo.Tag;
import com.yan.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class CatalogService {
    public PageResult findListByPage(QueryPageBean qb) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CatalogDao dao = sqlSession.getMapper(CatalogDao.class);
        List<Catalog> list = dao.findListByPage(qb);
        long l = dao.findCount(qb);
        return new PageResult(l,list);

    }

    public void add(Catalog catalog) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CatalogDao dao = sqlSession.getMapper(CatalogDao.class);
        dao.add(catalog);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    public void updateName(Catalog catalog) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CatalogDao dao = sqlSession.getMapper(CatalogDao.class);
        dao.updateName(catalog);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    public void updateStatus(Catalog catalog) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CatalogDao dao = sqlSession.getMapper(CatalogDao.class);
        Catalog c = dao.findOneById(catalog.getId());
        if (c.getStatus() == 1){
            c.setStatus(0);
        }else {
            c.setStatus(1);
        }
        dao.updateStatus(c);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    public void delete(int id) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CatalogDao dao = sqlSession.getMapper(CatalogDao.class);
        dao.delete(id);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }
}
