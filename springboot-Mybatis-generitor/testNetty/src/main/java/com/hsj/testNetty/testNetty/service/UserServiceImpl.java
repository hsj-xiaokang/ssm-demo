package com.hsj.testNetty.testNetty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsj.testNetty.testNetty.mapper.UserMapper;
import com.hsj.testNetty.testNetty.pojo.User;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserById(String id) {
        User user=userMapper.selectByPrimaryKey(id);
        return user;
    }
}
