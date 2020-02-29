package com.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EncodingController {

    @PostMapping("/e/t1")
    public String test01(String name, Model model){
        System.out.println("==========================");
        System.out.println(name);

        model.addAttribute("msg",name);

        return "main";
    }

}
