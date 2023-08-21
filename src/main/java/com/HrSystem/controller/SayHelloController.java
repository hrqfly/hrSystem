package com.HrSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hrq
 * #Description
 * #Date:   2023/3/14
 */

@Controller
@RequestMapping("/Test")
public class SayHelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello squirrel!";
        // generate a restful api

    }
}
