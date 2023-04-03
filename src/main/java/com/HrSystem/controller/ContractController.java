package com.HrSystem.controller;

import com.HrSystem.common.pojo.Result;
import com.HrSystem.entity.Contract;
import com.HrSystem.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hrq
 * @date 2023/03/19
 * 合同表Controller
 */
@RestController
@CrossOrigin
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping("/findcontract")
    public Result findContractByUserName(String userName){
        List<Contract> contracts = contractService.findContractByUserName(userName);
        if (contracts.isEmpty()){
            return Result.error("未查到相关合同信息");
        }
        return Result.ok(contracts);
    }

    @RequestMapping("/addContract")
    public Result addContract(Contract contract){
        int i = contractService.addContract(contract);
        if (i == 1){
             return Result.ok("插入合同数据成功");
        }
        return Result.error("合同数据插入失败");
    }

}
