package com.yan.service;

import com.yan.dao.CommonDao;
import com.yan.pojo.Course;
import com.yan.pojo.Dict;
import com.yan.utils.LocationUtil;
import com.yan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class CommonService {

    public Map findCities(HashMap map) throws IOException {
        SqlSession session = MybatisUtils.openSqlSession();
        CommonDao dao = session.getMapper(CommonDao.class);
        Dict dict = dao.findDict(LocationUtil.parseLocation((String) map.get("location")));
        List<Dict> list = dao.findList((Integer)map.get("fs"));
        Map<String,Object> result = new HashMap();
        result.put("location",dict);
        result.put("citys",list);
        return result;
    }

    public List<Course> findCourses() throws IOException {
        SqlSession session = MybatisUtils.openSqlSession();
        CommonDao dao = session.getMapper(CommonDao.class);
        List<Course> list = dao.findCourses();
        MybatisUtils.commitAndClose(session);
        return list;
    }
}
