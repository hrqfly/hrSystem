package com.HrSystem.controller;

import com.HrSystem.common.pojo.Result;
import com.HrSystem.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  hrq
 * @date 2023/03/30
 * 考勤controller
 */
@RestController
@CrossOrigin
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping("/signStart")
    public Result signStart(Integer userId){
        int insertNum = attendanceService.insertAttendance(userId);
        if (insertNum==0){
            return Result.error("上班打卡失败，请重新尝试");
        }
        return Result.ok("上班打卡成功，祝您工作愉快");
    }

    @RequestMapping("/signEnd")
    public Result signEnd(Integer userId){
        int addEndDateNum = attendanceService.addEndDate(userId);
        if (addEndDateNum==0){
            return Result.error("下班打卡失败，请重新尝试");
        }
        return Result.ok("下班打卡成功，感谢您一天的勤劳工作，再见");
    }
}
