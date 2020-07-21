package com.yan.service;

import com.yan.bean.Transfer;
import com.yan.dao.JTransferDao;
import com.yan.util.JDBCutil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class JTransferService {
    public boolean transfer(String from, String to, double money) throws SQLException {
        Connection connection = null;
        try {
            connection = JDBCutil.getConnection();
            connection.setAutoCommit(false);
            JTransferDao dao = new JTransferDao();
            Transfer f = dao.findByName(from,connection);
            Transfer t = dao.findByName(to,connection);
            f.setMoney(f.getMoney() - money);
            t.setMoney(t.getMoney() + money);
            dao.edit(f,connection);
//            int a = 1/0;
            dao.edit(t,connection);
            connection.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
            return false;
        }finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}
