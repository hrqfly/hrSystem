package com.HrSystem.service;

import com.HrSystem.entity.User;
import com.HrSystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(Integer id){
        User user = userMapper.selectById(id);
        return user;
    }

}
