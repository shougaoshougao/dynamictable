package com.sample.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sample.dynamictable.custom.DynamicTableHelper;
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

    @Override
    public List<User> listUsers(Integer tableSeq) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
                .gt(User::getId, 1);
        BaseMapper<User> mapper = DynamicTableHelper.getWrapperProxy(userMapper, tableSeq);
        return mapper.selectList(queryWrapper);
    }
}

