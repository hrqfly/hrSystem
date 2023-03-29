package com.HrSystem.entity;

import lombok.Data;

/**
 * 审批事件
 * @author hrq
 * @date 2023/03/29
 */

@Data
public class ApprovalEvent {
    private String topic;
    private Integer planId;
}
