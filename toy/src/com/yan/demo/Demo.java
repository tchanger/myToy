package com.yan.demo;

import com.yan.bean.Emp;
import com.yan.bean.QueryVo;
import com.yan.dao.EmpDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class Demo {

    private InputStream is;
    private SqlSession sqlSession;
    private EmpDao dao;

    @Test
    public void toy () throws Exception {
        String a ="aaa";
        System.out.println(a.hashCode());
        a="sss";
        System.out.println(a.hashCode());
        String e ="aaa";
        String b ="aaa";
        System.out.println(e.hashCode());
        System.out.println(e==b);
    }
    @Test
    public void fun01 () throws Exception{
        List<Emp> list = dao.findAll();
        System.out.println("ID\t\t姓名\t职位ID\t经理ID\t加入时间\t工资\t奖金\t部门ID");
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    public void fun02 () throws Exception {
        List<Emp> list = dao.findByDept(10);
        System.out.println("ID\t\t姓名\t职位ID\t经理ID\t加入时间\t工资\t奖金\t部门ID");
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    @Test
    public void fun03 () throws Exception {
        Emp emp = dao.findById(1005);
        System.out.println("ID\t\t姓名\t职位ID\t经理ID\t加入时间\t工资\t奖金\t部门ID");
        System.out.println(emp);
    }
    @Test
    public void fun04 () throws Exception {
        Emp emp = dao.findById(1005);
        List<Emp> list = dao.findMore(emp);
        System.out.println("ID\t\t姓名\t职位ID\t经理ID\t加入时间\t工资\t奖金\t部门ID");
        for (Emp emp2 : list) {
            System.out.println(emp2);
        }
    }
    @Test
    public void fun05 () throws Exception {
        Integer [] Array = {1005,1006,1007};
        List<Emp> list = dao.findByArray(Array);
        System.out.println("ID\t\t姓名\t职位ID\t经理ID\t加入时间\t工资\t奖金\t部门ID");
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    public void fun06 () throws Exception {
        QueryVo vo = new QueryVo();
        int [] Array = {1005,1006,1007};
        vo.setIds(Array);
        List<Emp> list = dao.findByIds(vo);
        System.out.println("ID\t\t姓名\t职位ID\t经理ID\t加入时间\t工资\t奖金\t部门ID");
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    @Test
    public void fun07 () throws Exception {
        int i = dao.updateEmp(1001);

    }

    @After
    public void desjory () throws Exception {
        sqlSession.close();
        is.close();
    }
    @Before
    public void init () throws Exception {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSession = new SqlSessionFactoryBuilder().build(is).openSession();
        dao = sqlSession.getMapper(EmpDao.class);
    }


}
