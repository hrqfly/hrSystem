package com.HrSystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author hrq
 * @date 2023/3/14
 */

@Data
public class Salary {

    @TableId(type= IdType.AUTO)
    private Integer id;
    public Integer userId;
    public String userName;
    public Integer wage;
    public String level;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date date;
}
