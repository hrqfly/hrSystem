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

import java.util.HashSet;
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
        Long addNum = employeePortraitsService.addEmployeePortraitsInf(employeePortraitsInf);
        if (addNum > 0){
            return Result.ok("信息添加成功");
        }
        return Result.ok("未成功添加任何信息");
    }

    @RequestMapping("/deleteEmployeePortraitsInf")
    public Result deleteEmployeePortraitsInf(@RequestBody EmployeePortraitsInf employeePortraitsInf){
        Long removeNum = employeePortraitsService.deleteEmployeePortraitsInf(employeePortraitsInf);
        if (removeNum>0){
            return Result.ok("删除成功");
        }
        return Result.ok("尝试删除的信息不存在");
    }



    @RequestMapping("/getEmployeePortraitsInf")
    public Result getEmployeePortraitsInf(Integer userId,String type){
        Set<String> employeePortraitsInf = employeePortraitsService.getEmployeePortraitsInf(userId, type);
        return Result.ok(employeePortraitsInf);
    }

    @RequestMapping("/getAllEmployeePortraitsInf")
    public Result getAllEmployeePortraitsInf(Integer userId){
        String[] type = new String[]{"Skills","personality","jobDev","Hobbies"};
        Set<String> allEmployeePortraitsInf = new HashSet<>();
        for (int i = 0 ; i < type.length ; i++){
            Set<String> employeePortraitsInf = employeePortraitsService.getEmployeePortraitsInf(userId, type[i]);
            for (String s : employeePortraitsInf){
                allEmployeePortraitsInf.add(s);
            }
        }
        return Result.ok(allEmployeePortraitsInf);
    }
}
