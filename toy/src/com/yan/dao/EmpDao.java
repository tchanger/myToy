package com.yan.dao;

import com.yan.bean.Emp;
import com.yan.bean.QueryVo;

import java.util.List;

public interface EmpDao {
    List<Emp> findMore(Emp emp);
    List<Emp> findAll();
    List<Emp> findByDept(int i);
    Emp findById(int id);

    List<Emp> findByIds(QueryVo vo);

    List<Emp> findByArray(Integer[] array);

    int updateEmp(int id);
}
