package com.yan.bean;

import java.lang.reflect.Method;

/**
 * @Author:yan
 * @Todo
 **/
@SuppressWarnings("all")
public class MetObj {
    private Method method;
    private Object obj;

    public MetObj() {
    }

    public MetObj(Method method, Object obj) {
        this.method = method;
        this.obj = obj;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
