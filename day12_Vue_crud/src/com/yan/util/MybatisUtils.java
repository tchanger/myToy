package com.yan.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis工具类
 * @author liuyp
 */
@SuppressWarnings("all")
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try(InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml")) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得SqlSession
     */
    public static SqlSession openSqlSession() throws IOException {
        return sqlSessionFactory.openSession();
    }

    /**
     * 提交释放资源
     */
    public static void commitAndClose(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    /**
     * 回滚释放资源
     */
    public static void rollbackAndClose(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}
