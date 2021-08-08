package com.sample.dynamictable.custom;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fangyun
 */
public class DynamicTableHelper {

    private static ConcurrentHashMap<String, BaseMapper> cache = new ConcurrentHashMap<>();

    public static BaseMapper getWrapperProxy(BaseMapper originMapper, Integer tableSeq) {
        String cacheKey = originMapper.getClass().getName() + tableSeq;
        // 使用并发缓存，如果缓存中没有则进行创建
        return cache.computeIfAbsent(cacheKey, key -> {
            // 将原mapper和tableSeq一起包装起来
            MapperWrapper mapperWrapper = new MapperWrapper(originMapper, tableSeq);
            // hanndler对包装类进行代理，在每个方法调用前，将tableSeq赋值给threadLocal，方法调用后清空threaLocal
            MapperInvocationHandler handler = new MapperInvocationHandler(mapperWrapper);
            // 生成代理类放入缓存中
            return (BaseMapper)Proxy.newProxyInstance(BaseMapper.class.getClassLoader(), originMapper.getClass().getInterfaces(), handler);
        });
    }

}
