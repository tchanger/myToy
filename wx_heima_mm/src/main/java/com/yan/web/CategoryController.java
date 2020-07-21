package com.yan.web;

import com.yan.anno.Controller;
import com.yan.anno.ResultMapping;
import com.yan.pojo.Catalog;
import com.yan.pojo.Question;
import com.yan.service.CategoryService;
import com.yan.utils.JsonUtils;

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
@Controller
public class CategoryController {
    CategoryService cs = new CategoryService();
    @ResultMapping("/category/list")
    public void findlist (HttpServletRequest request, HttpServletResponse response) throws IOException {
        HashMap params = JsonUtils.parseJSON2Object(request, HashMap.class);
        String openId = request.getHeader("Authorization");
        openId = openId.substring(7);
        Integer categoryType = (Integer) params.get("categoryType");
        Integer categoryKind = (Integer) params.get("categoryKind");
        List list = null;
        switch (categoryType){
            case 101:{
                list = cs.findList(categoryKind,openId);
                break;
            }
            case 201:{

                break;
            }
            case 202:{

                break;
            }
            case 203:{

                break;
            }
            default:{

            }
        }
        HashMap<String,Object> result = new HashMap();
        result.put("errmsg","加载列表成功");
        result.put("items",list);
        JsonUtils.printResult(response,result);
    }
}
