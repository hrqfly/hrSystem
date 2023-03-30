package com.HrSystem.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author hrq
 * @date 2023/03/30
 * 考勤Service 测试
 */

@SpringBootTest
public class AttendanceServiceTest {
    @Autowired
    private AttendanceService attendanceService;

    @Test
    public void testInsertAttendance(){
        int i = attendanceService.insertAttendance(2);
        System.out.println(i);
    }

    @Test
    public void testAddEndDate(){
        int i = attendanceService.addEndDate(2);
        System.out.println(i);
    }
}
