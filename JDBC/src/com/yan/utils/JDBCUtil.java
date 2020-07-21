package com.yan.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class JDBCUtil {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
        //读取配置文件
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
            driver =  bundle.getString("driver");
            url =  bundle.getString("url");
            username =  bundle.getString("username");
            password =  bundle.getString("password");
            //1. 注册驱动
            Class.forName(driver);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    public static void closeAll(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }

        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }

    }
    public static void closeSome(ResultSet resultSet, Statement statement) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
    }
}
