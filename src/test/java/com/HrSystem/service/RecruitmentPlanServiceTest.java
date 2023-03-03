package com.HrSystem.service;

import com.HrSystem.entity.RecruitmentPlan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RecruitmentPlanServiceTest {

    @Autowired
    private RecruitmentPlanService recruitmentPlanService;

    @Test
    public void testInsertService(){
        RecruitmentPlan recruitmentPlan = new RecruitmentPlan();
        recruitmentPlan.setAge("30-50");
        recruitmentPlan.setNum(5);
        recruitmentPlan.setPost("coo");
        recruitmentPlan.setRequirements("本科及以上，掌握计算机技术，熟练使用一门以上编程语言，吃苦耐劳，用爱发电");
        recruitmentPlan.setWages("7-9000");
        recruitmentPlanService.insertPlan(recruitmentPlan);
    }

    @Test
    public void testFindService(){
        List<RecruitmentPlan> plans = recruitmentPlanService.findPlanByPost("coo");
        System.out.println(plans.size());
        plans.forEach(System.out::println);
    }
}
