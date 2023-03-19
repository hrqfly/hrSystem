package com.HrSystem.entity;

import lombok.Data;

/**
 * @author hrq
 * @date 2023/03/17
 */

@Data
public class Loginticket {

    private Integer id;
    private Integer userId;
    private String ticket;
    private Integer expire;

}
