package com.yan.bean;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class Transfer {
    private Integer aid;
    private String name;
    private Double money;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
