package com.HrSystem.common.pojo;

import lombok.Data;

/**
 * @author hrq
 * @date 2023/4/16
 * 员工画像实体包装
 */

@Data
public class EmployeePortraitsInf {
    private Integer userId;
    private String type;
    private String content;
}
