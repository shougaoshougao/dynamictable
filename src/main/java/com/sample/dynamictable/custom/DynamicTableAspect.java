package com.sample.dynamictable.custom;

import com.sample.Constant;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DynamicTableAspect {

    @Around("within(MapperWrapper)")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        MapperWrapper mapperWrapper = (MapperWrapper) joinPoint.getTarget();
        Constant.THREAD_LOCAL_TABLE_SEQ.set(mapperWrapper.getTableSeq());
        Object returnValue = joinPoint.proceed();
        Constant.THREAD_LOCAL_TABLE_SEQ.remove();
        return returnValue;
    }

}
