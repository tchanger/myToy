package com.yan.utils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class JDBCutil{
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private Connection connection = null;
    static {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
            driver = bundle.getString("driver");
            url = bundle.getString("url");
            username = bundle.getString("username");
            password = bundle.getString("password");
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
    public static <T> T find(String sql,T t) throws Exception{
        //老三样
        Connection connection = JDBCutil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        //获得结果集元数据
        ResultSetMetaData metaData = resultSet.getMetaData();
        //获得表的列数
        int i1 = metaData.getColumnCount();
        //指针每移动一次，代表一个user对象
        while (resultSet.next()) {
            //获得user对象属性的集合
            Field[] fields = t.getClass().getDeclaredFields();
            //遍历对每一个属性进行赋值
            for (Field field : fields) {
                //对私有字段进行暴力破解
                field.setAccessible(true);
                //遍历表的每一条数据，当列名与属性名一致，则赋值
                for (int i = 1; i < i1; i++) {
                    if (metaData.getColumnName(i).equalsIgnoreCase(field.getName())){
                        field.set(t,resultSet.getObject(i));
                        break;
                    }
                }
            }
        }
        //释放资源
        JDBCutil.closeAll(resultSet,preparedStatement,connection);
        return t;
    }
}
