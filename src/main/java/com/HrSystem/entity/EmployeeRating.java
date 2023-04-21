package com.HrSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author hrq
 * @date 2023/04/21
 * 员工画像员工评分表
 */

@Data
public class EmployeeRating {

    @TableId(type= IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer professional;
    private Integer skills;
    private Integer careerDev;
    private Integer potential;
    private Integer interpersonal;
    private Integer approverId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private Boolean flag;
}
