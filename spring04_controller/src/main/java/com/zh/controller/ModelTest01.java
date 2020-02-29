package com.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelTest01 {

    @RequestMapping("/m1/t1")
    public String test01(Model model){

        model.addAttribute("msg","无视图解析器，隐式转发");

        return "/WEB-INF/jsp/main.jsp";
    }

    @RequestMapping("/m1/t2")
    public String test02(Model model){

        model.addAttribute("msg","无视图解析器，显示转发");

        return "forward:/WEB-INF/jsp/main.jsp";
    }

    @RequestMapping("/m1/t3")
    public String test03(Model model){

        model.addAttribute("msg","无视图解析器，重定向");

        return "redirect:/index.jsp";
    }
}
