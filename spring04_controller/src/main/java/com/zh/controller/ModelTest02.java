package com.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelTest02 {

    @RequestMapping("/m2/t1")
    public String test01(Model model){

        model.addAttribute("msg","视图解析器，转发是默认的，隐式的");

        return "main";
    }

    @RequestMapping("/m2/t2")
    public String test02(Model model){

        model.addAttribute("msg","视图解析器，重定向页面");

        return "redirect:/index.jsp";
    }

    @RequestMapping("/m2/t3")
    public String test03(){

        //视图解析器，重定向请求

        return "redirect:/m2/t1";
    }

}
