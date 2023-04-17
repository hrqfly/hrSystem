package com.HrSystem.controller;

import com.HrSystem.common.pojo.EmployeePortraitsInf;
import com.HrSystem.common.pojo.Result;
import com.HrSystem.service.EmployeePortraitsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author hrq
 * @date 2023/4/16
 * 员工画像服务层
 */

@RestController
@CrossOrigin
public class EmployeePortraitsController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeePortraitsService.class);

    @Autowired
    private EmployeePortraitsService employeePortraitsService;

    @RequestMapping("/addEmployeePortraitsInf")
    public Result addEmployeePortraitsInf(@RequestBody EmployeePortraitsInf employeePortraitsInf){
        employeePortraitsService.addEmployeePortraitsInf(employeePortraitsInf);
        return Result.ok("信息添加成功");
    }

    @RequestMapping("/getEmployeePortraitsInf")
    public Result getEmployeePortraitsInf(Integer userId,String type){
        Set<String> employeePortraitsInf = employeePortraitsService.getEmployeePortraitsInf(userId, type);
        return Result.ok(employeePortraitsInf);
    }
}
