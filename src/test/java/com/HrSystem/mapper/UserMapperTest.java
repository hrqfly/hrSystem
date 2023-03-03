package com.HrSystem.mapper;

import com.HrSystem.HrSystemApplication;
import com.HrSystem.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testUserMapper() {
        User user = new User();
        user.setAge(19);
        user.setName("fly");
        user.setPassword("12345");
        int insert = userMapper.insert(user);
        System.out.println(insert);
//        List<User> users = userMapper.selectList(null);
//        users.forEach(System.out::println);
    }

}
