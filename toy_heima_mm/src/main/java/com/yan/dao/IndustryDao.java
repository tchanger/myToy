package com.yan.dao;

import com.yan.pojo.Industry;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IndustryDao {

    @Select("select id,name from t_industry where id in (select industry_id from tr_company_industry where company_id = #{id})")
    List<Industry> findIndustryByCompany(Integer id);


    @Select("select * from t_industry")
    List<Industry> findIndustryList();

}
