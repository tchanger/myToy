package com.yan.service;

import com.yan.dao.CompanyDao;
import com.yan.dao.CourseDao;
import com.yan.pojo.Company;
import com.yan.pojo.Course;
import com.yan.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class CompanyService {
    public List<Company> findCompanyList() throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtils.openSqlSession();
        CompanyDao dao = sqlSession.getMapper(CompanyDao.class);
        List<Company> list = dao.findCompanyList();
        SqlSessionFactoryUtils.commitAndClose(sqlSession);
        return list;
    }
}
