package com.yan.service;

import com.yan.bean.PageBean;
import com.yan.bean.User;
import com.yan.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class UserService {
    public List<User> findAll() {
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = builder.build(is);
            SqlSession sqlSession = build.openSession();
            UserDao dao = sqlSession.getMapper(UserDao.class);
            List<User> list = dao.findAll();
            sqlSession.close();
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(User user) {
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = builder.build(is);
            SqlSession sqlSession = build.openSession();
            UserDao dao = sqlSession.getMapper(UserDao.class);
            dao.update(user);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User findPage(int id) {
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = builder.build(is);
            SqlSession sqlSession = build.openSession();
            UserDao dao = sqlSession.getMapper(UserDao.class);
            User user = dao.findPage(id);
            sqlSession.close();
            return user;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void delete(int id) {
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = builder.build(is);
            SqlSession sqlSession = build.openSession();
            UserDao dao = sqlSession.getMapper(UserDao.class);
            dao.delete(id);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(User user) {
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = builder.build(is);
            SqlSession sqlSession = build.openSession();
            UserDao dao = sqlSession.getMapper(UserDao.class);
            dao.add(user);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PageBean<User> pageQuery(int pageNumber, int pageSize) throws IOException {
        PageBean<User> pageBean = new PageBean<>();
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(is);
        SqlSession sqlSession = build.openSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);

        pageBean.setPageNumber(pageNumber);

        pageBean.setPageSize(pageSize);

        int totalCount = dao.totalCount();
        int pageCount = (int) Math.ceil(totalCount * 1.0 / pageSize);
        pageBean.setPageCount(pageCount);

        int startIndex = (pageNumber - 1) * pageSize;
        List<User> dataList = dao.pageQuery(startIndex, pageSize);
        pageBean.setDataList(dataList);

        sqlSession.commit();
        sqlSession.close();
        return pageBean;
    }
}
