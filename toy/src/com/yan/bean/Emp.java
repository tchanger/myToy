package com.yan.bean;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class Emp {
    private Integer id;
    private String ename;
    private Integer jobId;
    private Integer mgr;
    private String joindate;
    private Double salary;
    private Double bonus;
    private Integer deptId;

    public Emp() {
    }

    public Emp(Integer id, String ename, Integer jobId, Integer mgr, String joindate, Double salary, Double bonus, Integer deptId) {
        this.id = id;
        this.ename = ename;
        this.jobId = jobId;
        this.mgr = mgr;
        this.joindate = joindate;
        this.salary = salary;
        this.bonus = bonus;
        this.deptId = deptId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return id +
                "\t" + ename +
                "\t" + jobId +
                "\t\t" + mgr +
                "\t" + joindate +
                "\t" + salary +
                "\t" + bonus +
                "\t" + deptId;
    }
}
