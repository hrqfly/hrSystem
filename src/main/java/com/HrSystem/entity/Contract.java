package com.HrSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author hrq
 * @date 2023/03/19
 * 合同表，存储基本的合同信息
 */

@Data
public class Contract {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String userName;
    private String idNum;
    private String post;
    private Integer wage;
    private String content;
    private String contact;
    private String phoneNum;
    private String email;
    private String dateEntry;
}
