package com.yan.dao;

import com.yan.pojo.User;
import com.yan.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class UserDao {
    private static Connection connection = null;
    static {
        try {
            connection = JDBCUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAll() {
        try {
            String sql = "select * from linkman";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> list = new ArrayList();
            while (resultSet.next()){
                list.add(new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7)));
            }
            JDBCUtil.closeSome(resultSet,preparedStatement);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void add(User user) {
        try {
            String sql = "insert into linkman values(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,null);
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getSex());
            preparedStatement.setInt(4,user.getAge());
            preparedStatement.setString(5,user.getAddress());
            preparedStatement.setString(6,user.getQq());
            preparedStatement.setString(7,user.getEmail());
            preparedStatement.executeUpdate();
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            String sql = "delete from linkman where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(User user) {
        try {
            String sql = "update linkman set sex = ?,age = ?,address = ?,qq = ?,email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getSex());
            preparedStatement.setInt(2,user.getAge());
            preparedStatement.setString(3,user.getAddress());
            preparedStatement.setString(4,user.getQq());
            preparedStatement.setString(5,user.getEmail());
            preparedStatement.executeUpdate();
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public User findPage(int id) {
        try {
            String sql = "select * from linkman where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            User user = new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));
            JDBCUtil.closeSome(resultSet,preparedStatement);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
