package com.yan.dao.impl;

import com.yan.bean.Account;
import com.yan.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Author:yan
 * @Todo
 **/
@Repository
@SuppressWarnings("all")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Account findByName(String name) {
        return jdbcTemplate.queryForObject("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),name);
    }

    public void edit(Account account) {
        jdbcTemplate.update("update account set money = ? , name = ? where aid = ?",account.getMoney(),account.getName(),account.getAid());
    }
}
