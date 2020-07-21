package com.yan.test;

import com.yan.bean.Account;
import com.yan.bean.User;
import com.yan.dao.AccountDao;
import com.yan.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class Demo {

    private AccountDao accountDao;
    private UserDao userDao;
    private SqlSession session;
    private InputStream is;

    @Test
    public void UserqueryAllList () throws Exception {
        List<User> list = userDao.queryAllList();
        for (User u : list) {
            System.out.println(u.getUsername() + "," + u.getSex());
        }
        for (User u : list) {
            System.out.println(u.getList());
        }
    }
    @Test
    public void AccountQueryAllUser () throws Exception {
        List<Account> list = accountDao.queryAllUser();
        for (Account a : list) {
            System.out.println(a.getId() + "," + a.getMoney());
        }
        for (Account a : list) {
            System.out.println(a.getUser());
        }
    }
    @Test
    public void UserSerch1 () throws Exception {
        List<User>list = userDao.serch1("%王%");
        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void UserSerch2 () throws Exception {
        List<User>list = userDao.serch2("%王%");
        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void saveUser () throws Exception {
        User user = new User();
        user.setUsername("zs");
        user.setSex("女");
        user.setBirthday(new Date());
        user.setAddress("tb");
        userDao.save(user);
        session.commit();
        System.out.println(user);
    }
    @Test
    public void delete () throws Exception {
        userDao.delete(51);
        session.commit();
    }
    @Test
    public void edit () throws Exception {
        User user = new User();
        user.setId(49);
        user.setUsername("ls");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("此地");
        userDao.edit(user);
        session.commit();
    }
    @Test
    public void toy () throws Exception {
        String a = "aaa";
        String b = new String("aaa");
        String d = new String("aaa");
        String c = "aaa";
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(b==c);
        System.out.println(b==d);
    }
    @Before
    public void init() throws Exception{
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        session = build.openSession();
        userDao = session.getMapper(UserDao.class);
        accountDao = session.getMapper(AccountDao.class);
    }
    @After
    public void destory() throws Exception {
        session.close();
        is.close();
    }
}
