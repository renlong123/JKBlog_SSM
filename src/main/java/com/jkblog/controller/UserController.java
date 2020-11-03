package com.jkblog.controller;

import com.jkblog.bean.BlogUser;
import com.jkblog.exception.UserInfoNotCorrectException;
import com.jkblog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

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

    /*跳转进入登录页面*/
    @GetMapping("/login")
    public String userLogin(){
        log.debug("进入登录页面");
        return "userLogin";
    }

    /*跳转进入登录页面*/
    @GetMapping("/register")
    public String userRegister(){
        log.debug("进入注册页面");
        return "userRegister";
    }

    /**
     * 发起注册请求
     * @param blogUser
     * @return
     */
    @PostMapping("/register")
    public String userRegister(@Validated BlogUser blogUser, BindingResult result, Model model) throws UserInfoNotCorrectException {
        log.debug("发起了注册请求");

        if(result.hasErrors()){
            List<ObjectError> allErrors = result.getAllErrors();

            for(ObjectError error: allErrors){
                log.debug("出错了，错误： "+error);
            }
            model.addAttribute("errors",allErrors);
            return "userRegister";
        }

/*        int status = 0;
        String userName = blogUser.getUserName();
        String userPassword = blogUser.getUserPassword();
        String userGender = blogUser.getUserGender();
        String userEmail = blogUser.getUserEmail();

        *//*再次进行用户信息校验*//*
        if(userName == null || userName.length()< 2 || userName.length()> 50){
            status = 1;
        }
        if(userPassword == null || userPassword.length() < 6 || userPassword.length()> 50){
            status = 1;
        }
        if(userGender == null || (!(userGender.equals("0") || userGender.equals("1") ||userGender.equals("2")))){
            status = 1;
        }
        if(userEmail == null || userEmail.length()<2){
            status = 1;
        }

        if(status == 1){
            throw new UserInfoNotCorrectException("用户注册信息有错误，请稍后再试或与管理员联系");
        }else{*/
            blogUser.setUserCreateTime(new Date());
            blogUser.setUserDescription("还没有写");

            int i = userService.insertUser(blogUser);

            if( i>= 1){
                return "redirect:login";
            }else{
                throw new UserInfoNotCorrectException("用户注册失败，请稍后再试或与管理员联系");
            }
        /*}*/
    }

    /**
     * 名字校验请求，与数据库对比检测用户名是否被使用了
     * @return
     */
    @ResponseBody
    @RequestMapping("/namevalidate")
    public String userNameValidate(@RequestParam("userName")String userName, HttpSession session){
        String userName1 = (String)session.getAttribute("userName");
        if(userName != null && userName.equals(userName1)){
            return "true";
        }else{
            String s = userService.checkUserIsOccupied(userName);
            return s;
        }
    }
}
