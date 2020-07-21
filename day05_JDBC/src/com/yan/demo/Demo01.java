package com.yan.demo;

import com.yan.bean.User;
import com.yan.utils.JDBCutil;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class Demo01 {

    @Test
    public void add ()throws Exception{
        String sql = "insert into users(username,password,name,birthday,age,sex) values (?,?,?,?,?,?)";
        Object [] parms = {"aebs","aebs","阿尔卑斯","2000-2-2","20","女"};
        updateTable(sql, parms);
    }
    @Test
    public void delete ()throws Exception{
        Connection connection = JDBCutil.getConnection();
        String sql = "delete from users where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,6);
        preparedStatement.executeUpdate();
        JDBCutil.closeAll(null,preparedStatement,connection);
    }

    @Test
    public void update () throws Exception{
        Connection connection = JDBCutil.getConnection();
        String sql = "update users set sex = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,"女");
        preparedStatement.setObject(2,1);
        preparedStatement.executeUpdate();
        JDBCutil.closeAll(null,preparedStatement,connection);
    }

    @Test
    public void queryAll () throws Exception{
        String sql = "select * from users";
//        Connection connection = JDBCutil.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            System.out.print(resultSet.getString(1) + "\t");
//            System.out.print(resultSet.getString(2) + "\t");
//            System.out.print(resultSet.getString(3) + "\t");
//            System.out.print(resultSet.getString(4) + "\t");
//            System.out.print(resultSet.getString(5) + "\t");
//            System.out.print(resultSet.getString(6) + "\t");
//            System.out.println(resultSet.getString(7));
//        }
//        JDBCutil.closeAll(resultSet,preparedStatement,connection);
        JDBCutil.find(sql,new User());
    }



    private void updateTable(String sql, Object... parms) throws SQLException {
        Connection connection = JDBCutil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
        int i = parameterMetaData.getParameterCount();
        for (int i1 = 0; i1 < i; i1++) {
            preparedStatement.setObject(i1+1,parms[i1]);
        }
        preparedStatement.executeUpdate();
        JDBCutil.closeAll(null,preparedStatement,connection);
    }
}
