package com.yan.service;

import com.yan.bean.Transfer;
import com.yan.dao.MTransferDao;
import com.yan.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class MTransferService {
    public boolean transfer(String from, String to, double money) throws IOException {
        SqlSession sqlSession = MybatisUtils.openSqlSession();
        try {
            MTransferDao dao = sqlSession.getMapper(MTransferDao.class);
            Transfer f = dao.findByName(from);
            Transfer t = dao.findByName(to);
            f.setMoney(f.getMoney() - money);
            t.setMoney(t.getMoney() + money);
            dao.edit(f);
//            int a = 1/0;
            dao.edit(t);
            MybatisUtils.commitAndClose(sqlSession);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            MybatisUtils.rollbackAndClose(sqlSession);
            return false;
        }
    }
}
