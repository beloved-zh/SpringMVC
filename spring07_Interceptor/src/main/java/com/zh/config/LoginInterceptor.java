package com.zh.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取session
        HttpSession session = request.getSession();

        //获取用户信息
        Object user = session.getAttribute("user");

        //判断有用户信息放行
        if (user != null){
            return true;
        }

        //判断是否去登录页面请求
        if (request.getRequestURI().contains("gologin")){
            return true;
        }

        //判断是否登录请求
        if (request.getRequestURI().contains("login")){
            return true;
        }

        //其余拦截，跳转登录页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }
}
