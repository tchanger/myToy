package com.yan.service.impl;

import com.yan.bean.Account;
import com.yan.dao.AccountDao;
import com.yan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:yan
 * @Todo
 **/
@Service
@SuppressWarnings("all")
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    public Account findByName(String name) {
        return accountDao.findByName(name);
    }

    public void transfer(String fromName, String toName, Float money) {
        Account from = accountDao.findByName(fromName);
        Account to = accountDao.findByName(toName);
        from.setMoney(from.getMoney() - money);
        to.setMoney(to.getMoney() + money);
        accountDao.edit(from);
//        int i = 1/0;
        accountDao.edit(to);
    }

}
