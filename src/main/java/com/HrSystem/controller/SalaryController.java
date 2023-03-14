package com.HrSystem.controller;

import com.HrSystem.common.pojo.Result;
import com.HrSystem.entity.Salary;
import com.HrSystem.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hrq
 * @date 2023/3/14
 */

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @GetMapping("/getsalary")
    public Result getSalaryByUserId(Integer userId){
        List<Salary> salaryByUserId = salaryService.findSalaryByUserId(userId);
        if (salaryByUserId.isEmpty()){
            return Result.error("未查到关于该员工的薪资信息");
        }
        return Result.ok(salaryByUserId);
    }

}
