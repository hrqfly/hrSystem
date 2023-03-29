package com.HrSystem.controller;


import com.HrSystem.common.pojo.Result;
import com.HrSystem.entity.RecruitmentPlan;
import com.HrSystem.service.RecruitmentPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hrq
 * @date 2023/3/10
 */

@RestController
@CrossOrigin
public class RecruitmentPlanController {

    @Autowired
    private RecruitmentPlanService recruitmentPlanService;

    @GetMapping("/findplan")
    public Result getRecruitmentPlanByPost(String post){
        List<RecruitmentPlan> planByPost = recruitmentPlanService.findPlanByPost(post);
        if (planByPost.isEmpty()){
            return Result.error("没有该职位的公告");
        }
        return Result.ok(planByPost);
    }

    @RequestMapping("/addplan")
    public Result insertRecruitmentPlan(@RequestBody RecruitmentPlan recruitmentPlan){
        int i = recruitmentPlanService.insertPlan(recruitmentPlan);
        if(i==0){
            return Result.error("发布招聘计划失败");
        }
        return Result.ok("招聘计划发布成功");
    }

    @GetMapping("/findUnApprovalPlan")
    public Result findUnApprovalPlan(Integer approverId){
        List<RecruitmentPlan> planByApproverId = recruitmentPlanService.findPlanByApproverId(approverId);
        if (planByApproverId.isEmpty()){
            return Result.ok("没有待审批的招聘计划");
        }
        return Result.ok(planByApproverId);
    }

    @RequestMapping("/approvalPlan")
    public Result approvalPlan(@RequestBody RecruitmentPlan recruitmentPlan){
        int i = recruitmentPlanService.approvePlan(recruitmentPlan);
        if (i==1) {
            return Result.ok();
        }else {
            return Result.error("审批有误");
        }
    }
}
