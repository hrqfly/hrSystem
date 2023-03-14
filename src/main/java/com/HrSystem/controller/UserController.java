package com.HrSystem.controller;

import com.HrSystem.common.pojo.Result;
import com.HrSystem.entity.User;
import com.HrSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/find")
    public User findUser(){
        return userService.findUserById(2);
    }

    @RequestMapping("login")
    public Result login(@RequestBody User user){
        User userById = userService.findUserById(user.getId());
        if (userById==null){
            return Result.error("nullUser");
        }
        String password1 = userById.getPassword();
        if (password1.equals(user.getPassword())){
            return Result.ok();
        }
        return Result.error("password Wrong");
    }

    @GetMapping("/searchuser")
    public Result searchUserByName(String name){
        List<User> users = userService.findUserByName(name);
        if (users.isEmpty()){
            return Result.error("No user called "+name);
        }
        return Result.ok(users);
    }

    @RequestMapping("/insertuser")
    public Result insertUser(@RequestBody User user){
        userService.insertUser(user);
        List<User> users = userService.findUserByName(user.getName());
        Integer id = 0;
        for (User u:users
             ) {
            if (u.getId()>id)
            id = u.getId();
        }
        return Result.ok(id.toString());
    }
}
