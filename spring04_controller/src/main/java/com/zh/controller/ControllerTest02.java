package com.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//代表这个类被spring接管，被这个注释的类，中的所有方法，
// 且过返回值是string，并且有具体的页面可以跳转，就会被视图解析器解析
public class ControllerTest02 {

    @RequestMapping("/t2")
    public String test01(Model model){

        model.addAttribute("msg","ControllerTest02");

        return "main";
    }

    @RequestMapping("/t3")
    public String test02(Model model){

        model.addAttribute("msg","ControllerTest02/test02");

        return "main";
    }

}
