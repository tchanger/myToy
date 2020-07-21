package com.yan.bean;

import lombok.Data;

import java.util.Date;


/**
 * @Author:yan
 * @Todo
 **/
@Data
@SuppressWarnings("all")
public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
}
