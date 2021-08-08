package com.sample.dynamictable.custom;

import com.sample.Constant;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author fangyun
 */
public class MapperInvocationHandler implements InvocationHandler {

    private MapperWrapper origin;

    public MapperInvocationHandler(MapperWrapper origin) {
        this.origin = origin;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Constant.THREAD_LOCAL_TABLE_SEQ.set(origin.getTableSeq());
        Object invoke = method.invoke(origin, args);
        Constant.THREAD_LOCAL_TABLE_SEQ.remove();
        return invoke;
    }
}
