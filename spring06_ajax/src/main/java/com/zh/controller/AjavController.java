package com.zh.controller;


import com.zh.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
//@RestController注解会自带将属性转换为json格式
public class AjavController {

    @RequestMapping("/a3")
    public String a3(String name,String pwd){
        String msg = "";

        if (name != null){
            if ("admin".equals(name)){
                msg = "ok";
            }else {
                msg = "用户名有误";
            }
        }

        if (pwd != null){
            if ("123456".equals(pwd)){
                msg = "ok";
            }else {
                msg = "密码有误";
            }
        }

        return msg;
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> list = new ArrayList<User>();

        list.add(new User(1,"张恒1",20,"男"));
        list.add(new User(2,"张恒2",20,"女"));
        list.add(new User(3,"张恒3",20,"男"));
        list.add(new User(4,"张恒4",20,"女"));

        return list;
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {

        if ("admin".equals(name)){
            response.getWriter().print("true");
        }else {
            response.getWriter().print("false");
        }

    }

    @RequestMapping("/t1")
    public String test01(){

        return "hello";
    }

}
