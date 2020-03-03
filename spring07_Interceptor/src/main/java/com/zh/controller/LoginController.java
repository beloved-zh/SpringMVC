package com.zh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    //注销
    @RequestMapping("/goOut")
    public String goOut(HttpSession session){

        session.removeAttribute("user");

        return "main";
    }

    //登录
    @RequestMapping("/login")
    public String login(HttpSession session,String username, String pwd){

        System.out.println("name:"+username+"===========pwd:"+pwd);

        session.setAttribute("user",username);

        return "main";
    }

    //去主页
    @RequestMapping("/gomain")
    public String goMain(){

        return "main";
    }

    //去登录页
    @RequestMapping("/gologin")
    public String goLogin(){

        return "login";
    }

}
