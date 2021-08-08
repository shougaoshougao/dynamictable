package com.sample;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.sample.dynamictable.ext.DynamicTableNameParser;
import com.sample.dynamictable.ext.ITableNameHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;

@Configuration
@MapperScan("com.sample.mapper")
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser();
        dynamicTableNameParser.setTableNameHandlerMap(new HashMap<String, ITableNameHandler>(2) {{
            put("user", (metaObject, sql, tableName) -> {
                Integer tableSeq = Constant.THREAD_LOCAL_TABLE_SEQ.get();
                return tableName + tableSeq;
            });
        }});
        paginationInterceptor.setSqlParserList(Collections.singletonList(dynamicTableNameParser));
        return paginationInterceptor;
    }

}
