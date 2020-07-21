package com.yan.dao;

import com.yan.pojo.Company;

import java.util.List;

public interface CompanyDao {
    List<Company> findCompanyList();
}
