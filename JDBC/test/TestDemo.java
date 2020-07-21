import com.mysql.jdbc.Driver;
import com.yan.utils.JDBCUtil;
import org.junit.Test;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class TestDemo {
    @Test
    public void fun() throws SQLException {
        //获得链接
        Connection connection = JDBCUtil.getConnection();
        //创建执行sql语句对象
        Statement statement = connection.createStatement();
        String sql = "select * from emp";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println(resultSet.getObject(1));
            System.out.println(resultSet.getObject(2));
            System.out.println(resultSet.getObject(3));
            System.out.println(resultSet.getObject(4));
        }
        //关闭资源
        JDBCUtil.closeAll(resultSet,statement,connection);
    }

    @Test
    public void fun2() throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from dept";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        System.out.println((Integer) (resultSet.getObject(1))+1);
        JDBCUtil.closeAll(resultSet,preparedStatement,connection);
    }
    @Test
    public void fun3() throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from emp where sal > ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,800);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getObject(2));
        }
        JDBCUtil.closeAll(resultSet,preparedStatement,connection);
    }

    @Test
    public void fun4() throws Exception {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from emp where hiredate > ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"1981-4-4");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getObject(2));
        }
        JDBCUtil.closeAll(resultSet,preparedStatement,connection);
    }

    @Test
    public void fun5() throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from emp where job = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"clerk");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getObject(2) + "\t" + resultSet.getObject(3));
        }
        System.out.println("---------------------------------");
        preparedStatement.setString(1,"salesman");
        ResultSet resultSet1 = preparedStatement.executeQuery();
        while (resultSet1.next()){
            System.out.println(resultSet1.getObject(2) + "\t" + resultSet1.getObject(3));
        }
        if (resultSet1 != null) {
            resultSet1.close();
        }
        JDBCUtil.closeAll(resultSet,preparedStatement,connection);
    }

    @Test
    public void fun6() throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        String sql = "";

    }
    @Test
    public void fun7 (){


    }
}
