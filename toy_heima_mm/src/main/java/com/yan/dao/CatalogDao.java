package com.yan.dao;

import com.yan.entity.QueryPageBean;
import com.yan.pojo.Catalog;
import com.yan.pojo.Tag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CatalogDao {

    List<Catalog> findListByPage(QueryPageBean qb);

    @Select("select * from t_catalog where course_id = #{id}")
    List<Catalog> findCatalogListByCourse(Integer id);

    @Select("select * from t_catalog where id = #{id}")
    Catalog findOneById(Integer id);

    long findCount(QueryPageBean qb);


    void add(Catalog catalog);

    @Update("update t_catalog set name = #{name} where id = #{id}")
    void updateName(Catalog catalog);

    @Update("update t_catalog set status = #{status} where id = #{id}")
    void updateStatus(Catalog catalog);

    @Delete("delete from t_catalog where id = #{id}")
    void delete(int id);
}
