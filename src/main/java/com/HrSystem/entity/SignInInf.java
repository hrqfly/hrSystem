package com.HrSystem.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author hrq
 * @date 2023/3/14
 */

@Data
public class SignInInf {

    //train id
    Integer id;
    //签到时间
    Date date;
    // 签到人id
    Integer userId;
    // 签到人姓名
    String userName;

}
