package com.yan.dao;

import com.yan.bean.Account;


public interface AccountDao {
    Account findByName(String name);
    void edit(Account account);
}
