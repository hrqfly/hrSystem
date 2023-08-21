package com.HrSystem.controller;


import com.HrSystem.common.pojo.Result;
import com.HrSystem.entity.SignInInf;
import com.HrSystem.entity.Train;
import com.HrSystem.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author hrq
 * @date 2023/3/11
 */

@RestController
@CrossOrigin
public class TrainController {

    @Autowired
    private TrainService trainService;


    @RequestMapping("/addtrain")
    public Result addTrainInf(@RequestBody Train train){
        train.getTime();
        int i = trainService.insertTrainInf(train);
        if (i==0){
            return Result.error("培训信息发布失败");
        }
        return Result.ok("培训信息发布成功");
    }

    @RequestMapping("/findtrain")
    public Result findTrainBytime(@RequestBody Date date){
        List<Train> trainsByDate = trainService.findTrainByDate(date);
        if (trainsByDate.isEmpty()){
            Result.error("没有在该时间之后开的培训");
        }
        return Result.ok(trainsByDate);
    }

    @RequestMapping("/trainsignin")
    public Result trainSignIn(@RequestBody SignInInf signInInf){
        trainService.TrainSingIn(signInInf);
        return Result.ok("签到成功！");
    }

    @GetMapping("/getSignInf")
    public Result getTrainInf(Integer trainId){
        Set<SignInInf> trainUsers = trainService.findTrainUsers(trainId);
        return Result.ok(trainUsers);
    }

    @GetMapping("/getUserTrainInf")
    public Result getUserSignInTrains(Integer userId){
        Set<Train> userSignInTrains = trainService.findUserSignInTrains(userId);
        return Result.ok(userSignInTrains);
    }

}
