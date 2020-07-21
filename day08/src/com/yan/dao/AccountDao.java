package com.yan.dao;

import com.yan.bean.Account;

import java.util.List;

public interface AccountDao {
    List<Account> userFindList(int id);

    List<Account> queryAllUser();
}
