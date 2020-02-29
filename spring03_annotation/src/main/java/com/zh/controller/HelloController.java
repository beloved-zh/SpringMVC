package com.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("HelloController")
public class HelloController {

    //真实访问地址，可以存在两个，具有父子关系
    //locatlhost:8080/项目名/HelloController/hello
    @RequestMapping("/hello")
    public String hello(Model model){

        //封装数据    向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","HelloSpringMVCAnnotation");

        //会被视图解析器处理  /jsp/main.jsp
        return "main";
    }

}
