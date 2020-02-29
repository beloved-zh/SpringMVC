package com.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c3")
public class ControllerTest03 {

    @RequestMapping("/t1")
    public String test01(Model model){

        model.addAttribute("msg","ControllerTest03");

        return "main";
    }

}
