package com.yan.service;

import com.yan.bean.Account;

public interface AccountService {
    Account findByName(String name);
    void transfer(String from, String to, Float money);
}
