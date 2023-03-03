package com.HrSystem.service;

import com.HrSystem.entity.RecruitmentPlan;
import com.HrSystem.mapper.RecruitmentPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class RecruitmentPlanService {
    
    @Autowired
    private RecruitmentPlanMapper recruitmentPlanMapper;
    
    public void insertPlan(RecruitmentPlan recruitmentPlan){
        recruitmentPlanMapper.insert(recruitmentPlan);
    }

    public List<RecruitmentPlan> findPlanByPost(String post){
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("post","coo");
        List<RecruitmentPlan> recruitmentPlans = recruitmentPlanMapper.selectByMap(map);
        return recruitmentPlans;
    }
}
