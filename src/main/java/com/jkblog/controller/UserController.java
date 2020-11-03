package com.jkblog.controller;

import com.jkblog.bean.BlogUser;
import com.jkblog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据用户名及密码登录，根据记住我标志选择是否对用户免登录
     * @param userName
     * @param userPassword
     * @param rememberMe
     * @return
     */
    @PostMapping("/login")
    public String userLogin(@RequestParam("userName")String userName, @RequestParam("userPassword")String userPassword,
                            @RequestParam("rememberMe")String rememberMe, HttpServletRequest request, HttpServletResponse response){

        response.setContentType("text/html;charset=UTF-8");

        log.debug("[{}]发起了登录请求",userName);
        String returnPage = userService.userLogin(userName, userPassword, rememberMe, request, response);
        return returnPage;
    }

    @GetMapping("/login")
    public String userLogin(){
        log.debug("进入登录页面");
        return "userLogin";
    }
}
