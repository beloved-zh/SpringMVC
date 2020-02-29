package com.zh.controller;

import com.zh.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/t4")
    public String test04(ModelMap map){

        map.addAttribute("msg","ModelMap");

        return "main";
    }


    //前端传递对象
    /*
    1.接收前端用户传递的参数，判断参数的名字，如果名字直接在方法上，可以直接使用
    2.如果传递的是一个对象User，匹配对象User中的字段名，如果名字一致OK，否则为null
     */
    @RequestMapping("/t3")
    public String test03(User user, Model model){
        //1.接受前端参数
        System.out.println(user);
        //2.将参数返回给前端
        model.addAttribute("msg",user);
        //3.跳转试图
        return "main";
    }

    @RequestMapping("/t2")
    public String test02(@RequestParam("userName") String name, Model model){
        //1.接受前端参数
        System.out.println("接受的前端参数为"+name);
        //2.将参数返回给前端
        model.addAttribute("msg",name);
        //3.跳转试图
        return "main";
    }


    @RequestMapping("/t1")
    public String test01(String name, Model model){

        //1.接受前端参数
        System.out.println("接受的前端参数为"+name);

        //2.将参数返回给前端
        model.addAttribute("msg",name);

        //3.跳转试图
        return "main";
    }

}
