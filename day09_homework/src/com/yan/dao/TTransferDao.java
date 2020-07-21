package com.yan.dao;

import com.yan.bean.Transfer;
import com.yan.util.JDBCutil;
import com.yan.util.TransactionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TTransferDao {

    public Transfer findByName(String name) throws Exception {
        Connection connection = TransactionManager.getConnection();
        String sql = "select * from account where name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        ResultSet resultSet = statement.executeQuery();
        Transfer transfer = JDBCutil.find(sql, new Transfer(), resultSet);
        statement.close();
        return transfer;
    }

    public void edit(Transfer f) throws SQLException {
        Connection connection = TransactionManager.getConnection();
        String sql = "update account set money = ? where aid = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1,f.getMoney());
        statement.setInt(2,f.getAid());
        statement.executeUpdate();
        statement.close();
    }
}
