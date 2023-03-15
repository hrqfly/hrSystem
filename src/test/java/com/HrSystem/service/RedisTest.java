package com.HrSystem.service;

import com.HrSystem.entity.SignInInf;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

/**
 * @author hrq
 * date 2023/03/14
 */

@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSet(){
        String redisKey = "hrSys:Test";
        String redisKey1 = "6";

        redisTemplate.opsForSet().add(redisKey,"giao1");
        redisTemplate.opsForSet().add(redisKey,"giao2");
        redisTemplate.opsForSet().add(redisKey,"giao3");
        redisTemplate.opsForSet().add(redisKey,"giao4");

        Set <SignInInf> members = redisTemplate.opsForSet().members(redisKey1);
        for (SignInInf s:
             members) {
            System.out.println(s);
        };
    }
}
