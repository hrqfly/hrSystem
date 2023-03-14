package com.HrSystem.service;

import com.HrSystem.entity.Salary;
import com.HrSystem.mapper.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
