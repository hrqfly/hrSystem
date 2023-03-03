package com.HrSystem.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {

    @TableId(type= IdType.AUTO)
    private Integer id;
    private String name;
    private String password;
    private Integer age;
    private String dept;
    private String post;
    private String phoneNum;
    private String level;
    private String headerUrl;
    private String email;
    private String salt;
    private Integer type;
}
