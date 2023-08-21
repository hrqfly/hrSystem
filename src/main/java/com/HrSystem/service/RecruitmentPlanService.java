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
        if (recruitmentPlan.getPost()==""){
            return 0;
        }
        if (recruitmentPlan.getApproverId()==null){
            return 0;
        }
        if (recruitmentPlan.getWages()==""){
            return 0;
        }
        if (recruitmentPlan.getRequirements()==""){
            return 0;
        }
        recruitmentPlan.setStatus(0);
        return recruitmentPlanMapper.insert(recruitmentPlan);
    }

    public int approvePlan(RecruitmentPlan recruitmentPlan){
        recruitmentPlan.setStatus(1);
        return recruitmentPlanMapper.updateById(recruitmentPlan);
    }

    public List<RecruitmentPlan> findPlanByPost(String post){
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("post",post);
        map.put("status","1");
        List<RecruitmentPlan> recruitmentPlans = recruitmentPlanMapper.selectByMap(map);
        return recruitmentPlans;
    }

    public List<RecruitmentPlan> findPlanByApproverId(Integer approverId){
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("approver_id",approverId);
        map.put("status","0");
        List<RecruitmentPlan> recruitmentPlans = recruitmentPlanMapper.selectByMap(map);
        return recruitmentPlans;
    }
}
