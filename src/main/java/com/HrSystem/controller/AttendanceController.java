package com.HrSystem.controller;

import com.HrSystem.common.pojo.Result;
import com.HrSystem.entity.Attendance;
import com.HrSystem.entity.QueryAttendanceModel;
import com.HrSystem.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/signStart")
    public Result signStart(Integer userId){
        int insertNum = attendanceService.insertAttendance(userId);
        if (insertNum==0){
            return Result.error("上班打卡失败，请重新尝试");
        }
        return Result.ok("上班打卡成功，祝您工作愉快");
    }

    @GetMapping("/signEnd")
    public Result signEnd(Integer userId){
        int addEndDateNum = attendanceService.addEndDate(userId);
        if (addEndDateNum==0){
            return Result.error("下班打卡失败，请重新尝试");
        }
        return Result.ok("下班打卡成功，感谢您一天的勤劳工作，再见");
    }

    @RequestMapping("/findAttendanceByDate")
    public Result findAttendanceByDate(@RequestBody QueryAttendanceModel model){
        List<Attendance> attendanceByDate = attendanceService.findAttendanceByDate(model.getStart(), model.getEnd(),model.getUserId());
        if (attendanceByDate.isEmpty()){
            Result.ok("未查到签到数据");
        }
        return Result.ok(attendanceByDate);
    }

    @RequestMapping("/getWorkDayNum")
    public Result getWorkDayNum(@RequestBody QueryAttendanceModel model){
        Integer workDayNum = attendanceService.getWorkDayNum(model.getStart(), model.getEnd());
        return Result.ok(workDayNum);
    }

}
