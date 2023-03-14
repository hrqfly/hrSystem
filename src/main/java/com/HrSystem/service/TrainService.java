package com.HrSystem.service;


import com.HrSystem.entity.Train;
import com.HrSystem.mapper.TrainMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author hrq
 * @date 2023/3/11
 */
@Service
public class TrainService {
    @Autowired
    private TrainMapper trainMapper;

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

}
