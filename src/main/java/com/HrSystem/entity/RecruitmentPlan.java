package com.HrSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class RecruitmentPlan {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String post;
    private Integer num;
    private String age;
    private String requirements;
    private String wages;
}
