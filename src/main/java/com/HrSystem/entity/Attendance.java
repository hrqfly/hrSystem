package com.HrSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author  hrq
 * @date 2023/03/30
 * 考勤表
 */

@Data
public class Attendance {

    @TableId(type= IdType.AUTO)
    private Integer id;
    private Integer userId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date signInDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date start;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date end;
    private Float duration;
}
