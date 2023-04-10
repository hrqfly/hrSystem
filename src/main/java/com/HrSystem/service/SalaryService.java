package com.HrSystem.service;

import com.HrSystem.entity.Contract;
import com.HrSystem.entity.Salary;
import com.HrSystem.entity.User;
import com.HrSystem.mapper.SalaryMapper;
import com.HrSystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author hrq
 * @date 2023/3/14
 */
@Service
public class SalaryService {

    @Autowired
    private SalaryMapper salaryMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ContractService contractService;

    public int insertSalary(Salary salary){
        int insert = salaryMapper.insert(salary);
        return insert;
    }

    public List<Salary> findSalaryByUserId(Integer userId){
        HashMap<String,Object> queryMap = new HashMap();
        queryMap.put("user_id",userId);
        List<Salary> salaries = salaryMapper.selectByMap(queryMap);
        return salaries;
    }

    public int generateSalaryByAttendance(Integer userId,Float rate){
        User user = userMapper.selectById(userId);
        Contract contractByUserId = contractService.findContractByUserId(userId);
        Salary salary = new Salary();
        if (contractByUserId==null){
            // 没找到该员工的合同
            return 0;
        }
        salary.setUserId(userId);
        salary.setDate(new Date());
        salary.setLevel(user.getLevel());
        salary.setWage((int) (contractByUserId.getWage()*rate));
        salary.setUserName(user.getName());
        int insertNum = salaryMapper.insert(salary);
        return insertNum;
    }
}
