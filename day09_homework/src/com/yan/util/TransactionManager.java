package com.yan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class TransactionManager {
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 开启事务
     */
    public static void startTransaction() throws SQLException {
        //获取连接
        Connection connection = getConnection();
        //开启事务
        connection.setAutoCommit(false);
        //使用ThreadLocal把连接绑定到当前线程上
        tl.set(connection);
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws SQLException {
        //先使用ThreadLocal从当前线程上获取
        Connection connection = tl.get();
        //如果当前线程上没有，就获取一个新连接
        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:mysql:///toy","root","123456");
        }
        return connection;
    }

    /**
     * 提交事务并关闭连接
     */
    public static void commitAndClose() throws SQLException {
        //从当前线程上获取连接
        Connection connection = tl.get();
        //提交事务
        connection.commit();
        //关闭连接
        connection.close();
    }

    /**
     * 回滚事务并关闭连接
     */
    public static void rollbackAndClose() throws SQLException {
        //从当前线程上获取连接
        Connection connection = tl.get();
        //回滚事务
        connection.rollback();
        //关闭连接
        connection.close();
    }
}
