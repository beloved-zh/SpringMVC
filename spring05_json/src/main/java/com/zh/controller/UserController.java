package com.zh.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zh.JsonUtils;
import com.zh.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// @Controller 走视图解析器
@RestController //整个类中的所以方法都不走视图解析器
public class UserController {

    /**
     * fastjson
     */
    @RequestMapping("j5")
    public String json05(){

        List<User> list = new ArrayList<User>();

        User user1 = new User("张恒1",18,"男");
        User user2 = new User("张恒1",18,"男");
        User user3 = new User("张恒1",18,"男");

        list.add(user1);
        list.add(user2);
        list.add(user3);


        return JSON.toJSONString(list);
    }

    @RequestMapping("j4")
    public String json04(){
        List<User> list = new ArrayList<User>();

        User user1 = new User("张恒1",18,"男");
        User user2 = new User("张恒2",18,"男");
        list.add(user1);
        list.add(user2);

        return JsonUtils.getJson(list);
    }

    @RequestMapping("j3")
    public String json03(){

        Date date = new Date();

        return JsonUtils.getJson(date,"yyyy-MM-dd HH:mm:ss");
    }


    @RequestMapping("j2")
    public String json02() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        List<User> list = new ArrayList<User>();

        User user1 = new User("张恒1",18,"男");
        User user2 = new User("张恒2",18,"男");
        User user3 = new User("张恒3",18,"男");
        User user4 = new User("张恒4",18,"男");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        String str = mapper.writeValueAsString(list);

        return str;
    }

    @RequestMapping("j1")
    //@ResponseBody  //不会走视图解析器，会直接返回一个字符串
    public String json01() throws JsonProcessingException {

        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();

        //创建一个对象
        User user = new User("张恒",18,"男");

        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(user);

        return str;
    }

}
