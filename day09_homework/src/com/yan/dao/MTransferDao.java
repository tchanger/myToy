package com.yan.dao;

import com.yan.bean.Transfer;
import org.apache.ibatis.annotations.Select;

public interface MTransferDao {
    @Select("select * from account where name = #{name}")
    Transfer findByName(String from);

    void edit(Transfer t);
}
