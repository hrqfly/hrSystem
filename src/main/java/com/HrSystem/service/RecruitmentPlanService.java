package com.HrSystem.service;

import com.HrSystem.entity.RecruitmentPlan;
import com.HrSystem.mapper.RecruitmentPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RecruitmentPlanService {
    
    @Autowired
    private RecruitmentPlanMapper recruitmentPlanMapper;
    
    public int insertPlan(RecruitmentPlan recruitmentPlan){
        return recruitmentPlanMapper.insert(recruitmentPlan);
    }

    public List<RecruitmentPlan> findPlanByPost(String post){
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("post",post);
        List<RecruitmentPlan> recruitmentPlans = recruitmentPlanMapper.selectByMap(map);
        return recruitmentPlans;
    }
}
