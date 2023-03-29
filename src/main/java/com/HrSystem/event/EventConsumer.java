//package com.HrSystem.event;
//
//import com.HrSystem.entity.ApprovalEvent;
//import com.HrSystem.entity.RecruitmentPlan;
//import com.HrSystem.service.RecruitmentPlanService;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class EventConsumer {
//
//    @Autowired
//    private RecruitmentPlanService recruitmentPlanService;
//
//    private static final String approvalTopicPrefix = "approval";
//
//
//    @KafkaListener(topics = approvalTopicPrefix)
//    public void handleApprovalPlan(ConsumerRecord record){
//        if (record==null||record.value()==null){
//            // 记录日志
//            System.out.println("消息内容有误");
//        }
//        // 取到事件
//        ApprovalEvent event = (ApprovalEvent) record.value();
//        // 根据事件取需要审批的招聘计划
//        RecruitmentPlan plan = recruitmentPlanService.findPlanById(event.getPlanId());
//        // 更新招聘计划为已审批状态
//        recruitmentPlanService.approvePlan(plan);
//    }
//
//}
