package com.HrSystem.service;

import com.HrSystem.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author hrq
 * @date 2023/3/16
 */

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUpdateUser(){
        User user = new User();
        user.setId(1);
        user.setName("Mr.moose");
        userService.updateUser(user);
    }

    @Test
    public void testSelectById(){
        User user = userService.findUserById(1);
        System.out.println(user);
    }

}
