package com.HrSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Test")
public class SayHelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello squirrel!";
    }
}
