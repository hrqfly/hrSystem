package com.HrSystem.service;


import com.HrSystem.entity.SignInInf;
import com.HrSystem.entity.Train;
import com.HrSystem.mapper.TrainMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author hrq
 * @date 2023/3/11
 */
@Service
public class TrainService {
    @Autowired
    private TrainMapper trainMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    public int insertTrainInf(Train train){
        int insert = trainMapper.insert(train);
        return insert;
    }

    public List<Train> findTrainByDate(Date date){

        QueryWrapper<Train> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("time", date);
        List<Train> trains = trainMapper.selectList(queryWrapper);
        return trains;
    }

    public void TrainSingIn(SignInInf signInInf){
        String redisKey = signInInf.getId().toString();
        Date date = new Date();
        signInInf.setDate(date);
        redisTemplate.opsForSet().add(redisKey,signInInf);
    }

    public Set<SignInInf> findTrainUsers(Integer trainId){
        Set<SignInInf>members = redisTemplate.opsForSet().members(trainId.toString());
        return members;
    }
}
