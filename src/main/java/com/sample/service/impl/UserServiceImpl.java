package com.sample.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sample.dynamictable.custom.MapperWrapperHelper;
import com.sample.entity.User;
import com.sample.mapper.UserMapper;
import com.sample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final MapperWrapperHelper mapperWrapperHelper;

    @Override
    public List<User> listUsers(Integer tableSeq) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
                .gt(User::getId, 1);
        BaseMapper<User> mapper = mapperWrapperHelper.getMapperWrapper(userMapper, tableSeq);
        System.out.println(mapper);
        return mapper.selectList(queryWrapper);
    }

}

