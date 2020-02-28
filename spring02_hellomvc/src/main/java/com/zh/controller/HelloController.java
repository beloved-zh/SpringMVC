package com.zh.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView mv = new ModelAndView();

        //业务代码
        mv.addObject("msg","HelloSpringMVC");

        //视图跳转
        mv.setViewName("main"); // /jsp/main.jsp
        return mv;
    }
}

























