package com.HrSystem.controller;

import com.HrSystem.common.pojo.Result;
import com.HrSystem.entity.Contract;
import com.HrSystem.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result addContract(@RequestBody Contract contract){
        int i = contractService.addContract(contract);
        if (i == 1){
             return Result.ok("录入合同数据成功");
        }
        return Result.error("录入合同数据失败");
    }

}
