package com.HrSystem.service;

/**
 * @author hrq
 * @date 2023/4/16
 * 员工画像服务层
 */

import com.HrSystem.common.pojo.EmployeePortraitsInf;
import com.HrSystem.entity.EmployeeRating;
import com.HrSystem.mapper.EmployeeRatingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
public class EmployeePortraitsService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private EmployeeRatingMapper employeeRatingMapper;

    public static String redisKeyPrefix = "portraits";

    // 用户画像的维度定义
//    public static String employeeInf = "employeeInf";
//    public static String Skills = "Skills";
//    public static String personality = "personality";
//    public static String jobDev = "jobDev";
//    public static String Hobbies = "Hobbies";

    private static final Logger logger = LoggerFactory.getLogger(EmployeePortraitsService.class);

    public Long addEmployeePortraitsInf(EmployeePortraitsInf employeePortraitsInf){
        logger.info("run addEmployeePortraitsInf");
        String redisKey = redisKeyPrefix+employeePortraitsInf.getUserId()+employeePortraitsInf.getType();
        String[] content = employeePortraitsInf.getContent().split(",");
        Long addNum = 0L;
        for (String s:content){
            addNum += redisTemplate.opsForSet().add(redisKey,s);
        }
        return addNum;
    }



    public Set<String> getEmployeePortraitsInf(Integer userId,String type){
        logger.info("run getEmployeePortraitsInf");
        String redisKey = redisKeyPrefix+userId+type;
        Set<String> members = redisTemplate.opsForSet().members(redisKey);
        return members;
    }

    public Long deleteEmployeePortraitsInf(EmployeePortraitsInf employeePortraitsInf){
        logger.info("run deleteEmployeePortraitsInf");
        String redisKey = redisKeyPrefix+employeePortraitsInf.getUserId()+employeePortraitsInf.getType();
        String[] split = employeePortraitsInf.getContent().split(",");
        Long removeNum = 0L;
        for (String s : split){
            removeNum += redisTemplate.opsForSet().remove(redisKey, s);
        }
        return removeNum;
    }

    public EmployeeRating selectUnApprovalEmployeeRating(Integer userId){
        HashMap<String,Object> queryMap = new HashMap<>();
        queryMap.put("user_id",userId);
        queryMap.put("flag", false);
        List<EmployeeRating> employeeRatings = employeeRatingMapper.selectByMap(queryMap);
        if (employeeRatings.isEmpty()){
            return null;
        }
        return employeeRatings.get(0);
    }

    public Integer updateEmployeeRating(EmployeeRating employeeRating){
        employeeRating.setUpdateTime(new Date());
        employeeRating.setFlag(true);
        int updateNum = employeeRatingMapper.updateById(employeeRating);
        return updateNum;
    }

    public Integer InsertEmployeeRating(EmployeeRating employeeRating){
        employeeRating.setUpdateTime(new Date());
        employeeRating.setFlag(false);
        int insertNum = employeeRatingMapper.insert(employeeRating);
        return insertNum;
    }

    public EmployeeRating getApprovalEmployeeRating(Integer userId){
        HashMap<String,Object> queryMap = new HashMap<>();
        queryMap.put("user_id",userId);
        queryMap.put("flag", true);
        List<EmployeeRating> employeeRatings = employeeRatingMapper.selectByMap(queryMap);
        if (employeeRatings.isEmpty()){
            return null;
        }
        EmployeeRating latest = employeeRatings.get(0);
        for (EmployeeRating e:employeeRatings){
            if (e.getUpdateTime().after(latest.getUpdateTime())){
                latest = e;
            }
        }
        return latest;
    }

    public List<EmployeeRating> selectUnApprovalEmployeeRatingbyApr(Integer aprId){
        HashMap<String,Object> queryMap = new HashMap<>();
        queryMap.put("approver_id",aprId);
        queryMap.put("flag", false);
        List<EmployeeRating> employeeRatings = employeeRatingMapper.selectByMap(queryMap);
        if (employeeRatings.isEmpty()){
            return null;
        }
        return employeeRatings;
    }

}
