package com.HrSystem.controller;

import com.HrSystem.common.pojo.Result;
import com.HrSystem.entity.Salary;
import com.HrSystem.service.SalaryService;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.doReturn;



@ExtendWith(MockitoExtension.class)
class SalaryControllerTest {

    @InjectMocks
    private SalaryController salaryController;

    @Mock
    private SalaryService salaryService;



    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSalaryByUserId() {

        Salary salary = new Salary();
        salary.setId(1);
        salary.setDate(new Date());
        salary.setLevel("1");
        List<Salary> salaryByUserId = new ArrayList<>();
        salaryByUserId.add(salary);
        doReturn(salaryByUserId).when(salaryService).findSalaryByUserId(1);
        Result salaryByUserId1 = salaryController.getSalaryByUserId(1);
        Assert.assertNotNull(salaryByUserId1);
    }

    @Test
    void getSalaryByUserId_returnNull() {
        doReturn(new ArrayList<>()).when(salaryService).findSalaryByUserId(1);
        Result salaryByUserId1 = salaryController.getSalaryByUserId(1);
        Assert.assertNotNull(salaryByUserId1);
    }



    @Test
    void generateSalaryByAttendance() {
    }
}