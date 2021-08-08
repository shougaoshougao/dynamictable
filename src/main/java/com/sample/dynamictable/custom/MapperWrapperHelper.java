package com.sample.dynamictable.custom;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class MapperWrapperHelper {

    @Lookup
    @Cacheable("mapper")
    public MapperWrapper getMapperWrapper(BaseMapper originMapper, Integer tableSeq) {
        return null;
    }

}
