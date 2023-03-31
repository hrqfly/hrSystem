package com.HrSystem.service;

import com.HrSystem.entity.Attendance;
import com.HrSystem.mapper.AttendanceMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author  hrq
 * @date 2023/03/30
 * 考勤服务
 */

@Service
public class AttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;

    public int insertAttendance(Integer userId){
        Attendance attendance = new Attendance();
        attendance.setUserId(userId);
        Date signInDate = new Date();
        Date start = new Date();
        attendance.setSignInDate(signInDate);
        attendance.setStart(start);
        attendance.setEnd(start);
        attendance.setDuration(0F);
        int insertNum = attendanceMapper.insert(attendance);
        return insertNum;
    }

    public int addEndDate(Integer userId){

        Date date = new Date(System.currentTimeMillis()-1000*60*60*24);
        QueryWrapper<Attendance> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("sign_in_date",date);
        queryWrapper.eq("user_id",userId);
        Attendance attendance = attendanceMapper.selectOne(queryWrapper);

        if (attendance!=null) {
            // 定义一个一个小时代表的毫秒数
            float format = 1000 * 60 * 60;
            Date end = new Date();
            long l = end.getTime() - attendance.getStart().getTime();
            float duration = l / format;
            attendance.setEnd(new Date());
            attendance.setDuration(duration);
            int i = attendanceMapper.updateById(attendance);
            return i;
        }else {
            return 0;
        }
    }

    public List<Attendance> findAttendanceByDate(Date start,Date end,Integer userId){
        QueryWrapper<Attendance> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("sign_in_date",start);
        queryWrapper.le("sign_in_date",end);
        queryWrapper.eq("user_id",userId);
        List<Attendance> attendances = attendanceMapper.selectList(queryWrapper);
        return attendances;
    }
}
