package com.zh.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFulController {

    //原来的：http://localhost:8080/spring04_controller/add?a=1&b=2
    //RestFul http://localhost:8080/spring04_controller/add/1/2
    //@RequestMapping(value = "/add/{a}/{b}",method = {RequestMethod.GET})
    @GetMapping("/add/{a}/{b}")
    public String test01(@PathVariable int a,@PathVariable String b, Model model){

        String sum = a+b;
        model.addAttribute("msg","结果为"+sum);

        return "main";
    }

}
