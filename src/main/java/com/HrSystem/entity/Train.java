package com.HrSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author hrq
 * @date 2023/3/11
 */
@Data
public class Train {
    @TableId(type= IdType.AUTO)
    Integer id;
    String trainer;
    String topic;
    String content;
    String place;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date time;
    String useTime;

}
