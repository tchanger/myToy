package com.yan.bean;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class User {
    private Integer id;
    private String name;
    private String password;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return id +
                "\t" + name +
                "\t" + password;
    }
}
