package com.HrSystem.service;

import com.HrSystem.entity.Train;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * @author hrq
 * @date 2023/3/11
 */

@SpringBootTest
public class TrainServiceTest {

    @Autowired
    private TrainService trainService;

    @Test
    public void testInsert(){
        Train train = new Train();
        train.setTrainer("giao");
        train.setPlace("21b");
        train.setContent("讲解关于moose通用人力资源管理系统的使用");
        train.setTopic("通用人力资源系统");
        Date date = new Date();
        System.out.println(date.getTime());
        train.setTime(date);
        trainService.insertTrainInf(train);
    }

    @Test
    public void testFindByDate(){
        Date date = new Date();
        date.getTime();
        List<Train> trainByDate = trainService.findTrainByDate(date);
        for (Train t :
                trainByDate) {
            System.out.println(t);
        }
    }
}
