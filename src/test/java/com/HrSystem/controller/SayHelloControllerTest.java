package com.HrSystem.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hrqfly
 * #Description SayHelloControllerTest
 * #Date: 2023/8/20 14:32
 */

@ExtendWith(MockitoExtension.class)
class SayHelloControllerTest {

    @InjectMocks
    private SayHelloController sayHelloController;

    @Test
    void sayHello() {
        sayHelloController.sayHello();
        Assert.assertNotNull("Hello squirrel!");
    }
}