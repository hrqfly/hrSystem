package com.HrSystem.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hrq
 * date 2023/04/10
 * 获取一段时间内的工作日数量
 */

@Component
public class GetWorkDayNumUtil {

    public Integer getWorkDayNum(Date start,Date end){
        Integer workDayNum = 0;
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
                workDayNum++;
            }
            start.setTime(start.getTime()+1000*60*60*24);
        }
        return workDayNum;
    }
}
