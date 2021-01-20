package com.nifei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nifei.bean.User;
import com.nifei.mapper.UserMapper;
import com.nifei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User Loigin(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.setEntity(user);
        return userMapper.selectOne(wrapper);
    }
}
