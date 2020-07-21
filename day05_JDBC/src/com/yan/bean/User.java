package com.yan.bean;

import java.util.Date;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private Date birthday;
    private int age;
    private String sex;

    public User() {
    }

    public User(int id, String username, String password, String name, Date birthday, int age, String sex) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
