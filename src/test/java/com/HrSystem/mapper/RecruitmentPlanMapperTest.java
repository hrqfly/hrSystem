package com.HrSystem.mapper;

import com.HrSystem.entity.RecruitmentPlan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RecruitmentPlanMapperTest {
    
    @Autowired
    private RecruitmentPlanMapper recruitmentPlanMapper;

    @Test
    public void testInsert(){
        RecruitmentPlan recruitmentPlan = new RecruitmentPlan();
        recruitmentPlan.setAge("20-45");
        recruitmentPlan.setNum(5);
        recruitmentPlan.setPost("cfo");
        recruitmentPlan.setRequirements("吃苦耐劳，用爱发电");
        recruitmentPlan.setWages("6-8000");
        int insert = recruitmentPlanMapper.insert(recruitmentPlan);
    }
}
