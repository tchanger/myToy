package com.yan.service;

import com.yan.bean.Transfer;
import com.yan.dao.TTransferDao;
import com.yan.util.TransactionManager;

import java.sql.SQLException;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class TTransferService {

    public boolean transfer(String from, String to, double money) throws SQLException {
        try {
            TTransferDao dao = new TTransferDao();
            TransactionManager.startTransaction();
            Transfer f = dao.findByName(from);
            Transfer t = dao.findByName(to);
            f.setMoney(f.getMoney() - money);
            t.setMoney(t.getMoney() + money);
            dao.edit(f);
//            int a = 1/0;
            dao.edit(t);
            TransactionManager.commitAndClose();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionManager.rollbackAndClose();
            return false;
        }
    }
}
