package com.yan.dao;

import com.yan.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class UserDao {
    private static List<User> list = new ArrayList();
    static {
        list.add(new User(1, "大郎", "男", 33, "深圳", "12345", "12345@qq.com"));
        list.add(new User(2, "二郎", "男", 31, "深圳", "12312", "12312@qq.com"));
        list.add(new User(3, "张三", "女", 23, "广州", "54321", "54321@qq.com"));
        list.add(new User(4, "李四", "男", 20, "惠州", "12345", "12345@qq.com"));
        list.add(new User(5, "王五", "男", 24, "郑州", "55555", "55555@qq.com"));
        list.add(new User(6, "赵六", "男", 34, "兰州", "66666", "66666@qq.com"));
        list.add(new User(7, "钱七", "女", 22, "北京", "77777", "77777@qq.com"));
        list.add(new User(8, "张三丰", "男", 122, "武当", "77779", "77779@qq.com"));
        list.add(new User(9, "张无忌", "男", 22, "武当", "77778", "77778@qq.com"));
        list.add(new User(10, "张翠山", "男", 42, "武当", "77776", "77776@qq.com"));
        list.add(new User(11, "王小二", "男", 35, "北京", "77775", "77775@qq.com"));
        list.add(new User(12, "大白", "男", 43, "北京", "77774", "77774@qq.com"));
    }
    public List<User> findAll() {
        return list;
    }

    public void delete(int id) {
        list.remove(id);
    }

    public void update(User user) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == user.getId()) {
                list.set(i, user);
                break;
            }
        }
    }

    public boolean add(User user) {
        user.setId(list.get(list.size()-1).getId()+1);
        list.add(user);
        return true;
    }

    public User findOne(int id) {
        for (User user1 : list) {
            if (id == user1.getId()){
                return user1;
            }
        }
        return null;
    }
}
