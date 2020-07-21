package com.yan.dao;


import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CategoryDao {

    List<Map> findCatalog(String openId);


    List<Map> findCompany(String openId);


    List<Map> findIndustry(String openId);
}
