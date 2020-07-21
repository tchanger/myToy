package com.yan.service;

import com.yan.anno.Controller;
import com.yan.anno.ResultMapping;
import com.yan.dao.CategoryDao;
import com.yan.pojo.Catalog;
import com.yan.utils.JsonUtils;
import com.yan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:yan
 * @Todo
 **/

@SuppressWarnings("all")
public class CategoryService {


    public List findList(Integer categoryKind, String openId) throws IOException {
        SqlSession session = MybatisUtils.openSqlSession();
        CategoryDao dao = session.getMapper(CategoryDao.class);
        List<Map> list = null;
        switch (categoryKind){
            case 1:{
                list = dao.findCatalog(openId);
                break;
            }
            case 2:{
                list = dao.findCompany(openId);
                break;
            }
            case 3:{
                list = dao.findIndustry(openId);
                break;
            }
        }
        MybatisUtils.commitAndClose(session);
        return list;
    }
}
