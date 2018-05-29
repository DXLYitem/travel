package com.example.travel.util;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag=true;
        Object conList = request.getSession().getAttribute("conList");
        if(conList==null){
            flag=false;
        }
        if(!flag){
           response.sendRedirect("/index");
           return false;
       }
        return flag;
    }
}
