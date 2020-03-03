package com.zh.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/t1")
    public String test01(){

        System.out.println("test01执行了");

        return "ok";
    }

}
