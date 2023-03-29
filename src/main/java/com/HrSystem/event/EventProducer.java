//package com.HrSystem.event;
//
//import com.HrSystem.entity.ApprovalEvent;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * @author hrq
// * @date 2023/03/29
// * 事件生产者
// */
//
//@Component
//public class EventProducer {
//
//    @Resource
//    private KafkaTemplate kafkaTemplate;
//
//    private static final String approvalTopicPrefix = "approval";
//
//    // 处理审批事件
//    public void fireapprovalEvent(ApprovalEvent event) {
//        // 将事件发布到指定的主题
//        kafkaTemplate.send(event.getTopic(),event);
//    }
//
//}
