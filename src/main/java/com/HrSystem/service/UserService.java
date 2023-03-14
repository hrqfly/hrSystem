package com.HrSystem.service;

import com.HrSystem.entity.User;
import com.HrSystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(Integer id){
        User user = userMapper.selectById(id);
        return user;
    }

    public List<User> findUserByName(String name){
        HashMap<String, Object> queryMap = new HashMap<>();
        queryMap.put("name",name);
        List<User> users = userMapper.selectByMap(queryMap);
        return users;
    }

    public void insertUser(User user){
        userMapper.insert(user);
    }

}
