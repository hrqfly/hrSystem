package com.HrSystem.service;

import com.HrSystem.entity.Contract;
import com.HrSystem.mapper.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author hrq
 * @date 2023/03/19
 * 合同表Service
 */

@Service
public class ContractService {

    @Autowired
    private ContractMapper contractMapper;

    public List<Contract> findContractByUserName(String userName){

        HashMap<String,Object> queryMap = new HashMap<>();
        // 这里的字段要跟数据库里的字段一致，而不是跟自己定义的实体表里的一致
        queryMap.put("user_name",userName);
        List<Contract> contracts = contractMapper.selectByMap(queryMap);
        return contracts;
    }

    public int addContract(Contract contract){
        int insertNum = contractMapper.insert(contract);
        return insertNum;
    }

    public Contract findContractByUserId(Integer userId){
        HashMap<String,Object> queryMap = new HashMap<>();
        queryMap.put("user_id",userId);
        List<Contract> contracts = contractMapper.selectByMap(queryMap);
        if (!contracts.isEmpty()){
            return contracts.get(0);
        }
        // 没找到该员工的合同
        return null;
    }
}
