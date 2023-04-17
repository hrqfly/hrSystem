package com.HrSystem.service;

/**
 * @author hrq
 * @date 2023/4/16
 * 员工画像服务层
 */

import com.HrSystem.common.pojo.EmployeePortraitsInf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EmployeePortraitsService {
    @Autowired
    private RedisTemplate redisTemplate;

    public static String redisKeyPrefix = "portraits";

    // 用户画像的维度定义
//    public static String employeeInf = "employeeInf";
//    public static String Skills = "Skills";
//    public static String personality = "personality";
//    public static String jobDev = "jobDev";
//    public static String Hobbies = "Hobbies";

    private static final Logger logger = LoggerFactory.getLogger(EmployeePortraitsService.class);

    public void addEmployeePortraitsInf(EmployeePortraitsInf employeePortraitsInf){
        logger.info("run addEmployeePortraitsInf");
        String redisKey = redisKeyPrefix+employeePortraitsInf.getUserId()+employeePortraitsInf.getType();
        String[] content = employeePortraitsInf.getContent().split(",");
        for (String s:content){
            redisTemplate.opsForSet().add(redisKey,s);
        }
    }

    public Set<String> getEmployeePortraitsInf(Integer userId,String type){
        logger.info("run getEmployeePortraitsInf");
        String redisKey = redisKeyPrefix+userId+type;
        Set<String> members = redisTemplate.opsForSet().members(redisKey);
        return members;
    }
}
