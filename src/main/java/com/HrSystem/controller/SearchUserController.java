package com.HrSystem.controller;

import com.HrSystem.entity.User;
import com.HrSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class SearchUserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/find")
    public User findUser(){
        return userService.findUserById(2);
    }
}
