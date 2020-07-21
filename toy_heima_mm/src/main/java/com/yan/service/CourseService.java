package com.yan.service;

import com.yan.dao.CourseDao;
import com.yan.dao.QuestionDao;
import com.yan.entity.QueryPageBean;
import com.yan.pojo.Catalog;
import com.yan.pojo.Course;
import com.yan.pojo.Question;
import com.yan.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class CourseService {
    public List<Course> findCourseList() throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CourseDao dao = sqlSession.getMapper(CourseDao.class);
        List<Course> list = dao.findCourseList();
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return list;
    }

    public List<Course> findListByPage(QueryPageBean qb) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CourseDao dao = sqlSession.getMapper(CourseDao.class);
        List<Course> list = dao.findListByPage(qb);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return list;

    }

    public Long findCount(QueryPageBean qb) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CourseDao dao = sqlSession.getMapper(CourseDao.class);
        Long l = dao.findCount(qb);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return l;
    }

    public void add(Course course) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CourseDao dao = sqlSession.getMapper(CourseDao.class);
        dao.add(course);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    public void update(Course course) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CourseDao dao = sqlSession.getMapper(CourseDao.class);
        dao.update(course);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }

    public void delete(Course course) throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CourseDao dao = sqlSession.getMapper(CourseDao.class);
        dao.delete(course);
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
    }
}
