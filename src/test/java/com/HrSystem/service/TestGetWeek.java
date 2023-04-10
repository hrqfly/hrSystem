package com.HrSystem.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hrq
 * date 2023/04/10
 */
@SpringBootTest
public class TestGetWeek {

    @Test
    public void getWeek(){
        int dayNum = 0;
        Date start = new Date();
        Date end = new Date(System.currentTimeMillis()+1000*60*60*24*21);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
        Set<String> weekSet = new HashSet<>();
        weekSet.add("星期一");
        weekSet.add("星期二");
        weekSet.add("星期三");
        weekSet.add("星期四");
        weekSet.add("星期五");
        for (;start.before(end);)
        {
            String week = simpleDateFormat.format(start);
            if (weekSet.contains(week)){
                dayNum++;
            }
            start.setTime(start.getTime()+1000*60*60*24);
        }
        System.out.println(dayNum);
    }
}
