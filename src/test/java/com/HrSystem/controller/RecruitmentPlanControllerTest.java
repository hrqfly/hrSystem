package com.HrSystem.controller;

import com.HrSystem.common.pojo.Result;
import com.HrSystem.entity.RecruitmentPlan;
import com.HrSystem.entity.User;
import com.HrSystem.service.RecruitmentPlanService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)
class RecruitmentPlanControllerTest {

    @InjectMocks
    private RecruitmentPlanController recruitmentPlanController;

    @Mock
    private RecruitmentPlanService recruitmentPlanService;


    @Test
    void getRecruitmentPlanByPost() {
//        long currentTimeMillis = System.currentTimeMillis();
//        System.out.println(currentTimeMillis);
//        System.out.println("输出问我的测试体验");
//        List<Integer> integers = new ArrayList<Integer>();
//        for (int i = 0; i < 19; i++) {
//            if(i%2 == 0){
//                integers.add(i);
//            }
//        }
//        System.out.println(integers);
//        integers.forEach(System.out::println);
//
//        User u = new User();

    }

    @Test
    void insertRecruitmentPlan() {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,1);


    }

    @Test
    void findUnApprovalPlan_empty() {
        doReturn(new ArrayList<>()).when(recruitmentPlanService).findPlanByApproverId(anyInt());
        Result unApprovalPlan = recruitmentPlanController.findUnApprovalPlan(1);
        Assert.assertEquals(unApprovalPlan.getStatus().intValue(),200);
    }
    @Test
    void findUnApprovalPlan() {
        RecruitmentPlan recruitmentPlan = new RecruitmentPlan();
        recruitmentPlan.setApproverId(1);
        List<RecruitmentPlan> planByApproverId = new ArrayList<>();
        planByApproverId.add(recruitmentPlan);
        doReturn(planByApproverId).when(recruitmentPlanService).findPlanByApproverId(anyInt());
        Result unApprovalPlan = recruitmentPlanController.findUnApprovalPlan(1);
        Assert.assertEquals(unApprovalPlan.getStatus().intValue(),200);
    }

    @Test
    void approvalPlan() {
        doReturn(1).when(recruitmentPlanService).approvePlan(new RecruitmentPlan());
        Result result = recruitmentPlanController.approvalPlan(new RecruitmentPlan());
        Assert.assertEquals(200, result.getStatus().intValue());
    }

    @Test
    void approvalPlan_error() {
        doReturn(2).when(recruitmentPlanService).approvePlan(new RecruitmentPlan());
        Result result = recruitmentPlanController.approvalPlan(new RecruitmentPlan());
        Assert.assertEquals(400, result.getStatus().intValue());
    }

    @Test
    public void setUserAge(){
        User user = new User();
        setUserAge(user);
        Assert.assertEquals("giao",user.getName());
        Assert.assertEquals("13237857861",user.getPhoneNum());
    }

    private void setUserAge(User user){
        user.setAge(12);
        user.setName("giao");
        user.setId(1);
        user.setPhoneNum("13237857861");
    }
}