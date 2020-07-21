package com.yan.demo;

import com.yan.bean.User;
import com.yan.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class Demo01 {
    @Test
    public void fun01 () throws IOException {
        //1. 读取核心配置文件SqlMapConfig.xml
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建SqlSessionFactoryBuilder构造者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3. 使用构造者builder，根据配置文件的信息is，构造一个SqlSessionFactory工厂对象
        SqlSessionFactory factory = builder.build(is);
        //4. 使用工厂对象factory，生产一个SqlSession对象
        SqlSession session = factory.openSession();
        //5. 使用SqlSession对象，获取映射器UserDao接口的代理对象
        UserDao dao = session.getMapper(UserDao.class);
        //6. 调用UserDao代理对象的方法，查询所有用户
        List<User> users = dao.queryAll();
        for (User user : users) {
            System.out.println(user);
        }
        //7. 释放资源
        session.close();
        is.close();
    }
}
