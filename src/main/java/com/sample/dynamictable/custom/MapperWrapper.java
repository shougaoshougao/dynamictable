package com.sample.dynamictable.custom;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
public class MapperWrapper<T> implements BaseMapper<T> {

    private final BaseMapper<T> delegate;
    private final Integer tableSeq;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public MapperWrapper(BaseMapper<T> delegate, Integer tableSeq) {
        this.delegate = delegate;
        this.tableSeq = tableSeq;
    }

    public Integer getTableSeq() {
        return tableSeq;
    }

    @Override
    public int insert(T entity) {
        return delegate.insert(entity);
    }

    @Override
    public int deleteById(Serializable id) {
        return delegate.deleteById(id);
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        return delegate.deleteByMap(columnMap);
    }

    @Override
    public int delete(Wrapper<T> wrapper) {
        return delegate.delete(wrapper);
    }

    @Override
    public int deleteBatchIds(Collection<? extends Serializable> idList) {
        return delegate.deleteBatchIds(idList);
    }

    @Override
    public int updateById(T entity) {
        return delegate.updateById(entity);
    }

    @Override
    public int update(T entity, Wrapper<T> updateWrapper) {
        return delegate.update(entity, updateWrapper);
    }

    @Override
    public T selectById(Serializable id) {
        return delegate.selectById(id);
    }

    @Override
    public List<T> selectBatchIds(Collection<? extends Serializable> idList) {
        return delegate.selectBatchIds(idList);
    }

    @Override
    public List<T> selectByMap(Map<String, Object> columnMap) {
        return delegate.selectByMap(columnMap);
    }

    @Override
    public T selectOne(Wrapper<T> queryWrapper) {
        return delegate.selectOne(queryWrapper);
    }

    @Override
    public Integer selectCount(Wrapper<T> queryWrapper) {
        return delegate.selectCount(queryWrapper);
    }

    @Override
    public List<T> selectList(Wrapper<T> queryWrapper) {
        return delegate.selectList(queryWrapper);
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<T> queryWrapper) {
        return delegate.selectMaps(queryWrapper);
    }

    @Override
    public List<Object> selectObjs(Wrapper<T> queryWrapper) {
        return delegate.selectObjs(queryWrapper);
    }

    @Override
    public IPage<T> selectPage(IPage<T> page, Wrapper<T> queryWrapper) {
        return delegate.selectPage(page, queryWrapper);
    }

    @Override
    public IPage<Map<String, Object>> selectMapsPage(IPage<T> page, Wrapper<T> queryWrapper) {
        return delegate.selectMapsPage(page, queryWrapper);
    }
}
