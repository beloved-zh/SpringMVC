package com.zh.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//只要实现Controller接口的类，就是一个控制器
public class ControllerTest01 implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","ControllerTest01");
        mv.setViewName("main");

        return mv;
    }
}
