package com.HrSystem.service;

import com.HrSystem.entity.Contract;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author hrq
 * @date 2023/03/19
 * 合同表Service 测试
 */

@SpringBootTest
public class ContractServiceTest {
    @Autowired
    private ContractService contractService;

    @Test
    public void testFindContractByUserId(){
        List<Contract> contractByUserName = contractService.findContractByUserName("Mr.moose");
        for (Contract contract:
             contractByUserName) {
            System.out.println(contract);
        };
    }
}
