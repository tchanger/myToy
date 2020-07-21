package com.yan.datesource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class MyDatesource implements DataSource {
    private LinkedList<Connection> pool = new LinkedList();
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
            Class.forName(bundle.getString("driver"));
            url = bundle.getString("url");
            username = bundle.getString("username");
            password = bundle.getString("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MyDatesource(){
        try {
            for (int i = 0; i < 10; i++) {
                Connection connection = DriverManager.getConnection(url, username, password);
                Connection connPoxy = (Connection) Proxy.newProxyInstance(
                        connection.getClass().getClassLoader(),
                        connection.getClass().getInterfaces(),
                        new InvocationHandler() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                                if ("colose".equals(method.getName())) {
                                    pool.add((Connection) proxy);
                                    return null;
                                }
                                return method.invoke(connection,args);
                            }
                        }
                );
                pool.add(connPoxy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return pool.removeFirst();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
