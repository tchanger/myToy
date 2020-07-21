package com.yan.dao;

import com.yan.bean.Transfer;
import com.yan.util.JDBCutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JTransferDao {
    public Transfer findByName(String name, Connection connection) throws Exception {
        String sql = "select * from account where name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        ResultSet resultSet = statement.executeQuery();
        Transfer transfer = JDBCutil.find(sql, new Transfer(), resultSet);
        statement.close();
        return transfer;
    }

    public void edit(Transfer t , Connection connection) throws SQLException {
        String sql = "update account set money = ? where aid = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1,t.getMoney());
        statement.setInt(2,t.getAid());
        statement.executeUpdate();
        statement.close();
    }
}
