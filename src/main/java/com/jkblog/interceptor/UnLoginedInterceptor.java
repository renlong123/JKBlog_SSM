package com.jkblog.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UnLoginedInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Integer userId = (Integer) request.getSession().getAttribute("userId");

        /*当session中没有用户时*/
        if (userId == null || userId.equals("")) {
            /*没登陆时跳转到主页*/
            response.sendRedirect("index");
            return false;
        }else {
            return true;
        }
    }
}
