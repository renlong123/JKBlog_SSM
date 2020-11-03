package com.jkblog.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginedInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Integer userId = (Integer) request.getSession().getAttribute("userId");

        /*当session中没有用户时,可以访问页面*/
        if (userId == null || userId.equals("")) {
            return true;
        }else {
            /*已经登陆了跳转到个人主页*/
            response.sendRedirect("homepage");
            return false;
        }
    }
}
