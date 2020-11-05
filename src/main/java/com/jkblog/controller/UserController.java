package com.jkblog.controller;

import com.google.gson.Gson;
import com.jkblog.bean.Blog;
import com.jkblog.bean.BlogUser;
import com.jkblog.bean.UserHeadPic;
import com.jkblog.exception.UserInfoNotCorrectException;
import com.jkblog.service.BlogService;
import com.jkblog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/user")
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
                            @RequestParam(value = "rememberMe",required = false)String rememberMe,
                            HttpServletRequest request, HttpServletResponse response){

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

        blogUser.setUserCreateTime(new Date());
        blogUser.setUserDescription("还没有写");

        int i = userService.insertUser(blogUser);

        if( i>= 1){
            return "redirect:user/login";
        }else{
            throw new UserInfoNotCorrectException("用户注册失败，请稍后再试或与管理员联系");
        }

    }

    /**
     * 名字校验请求，与数据库对比检测用户名是否被使用了
     * @return
     */
    @ResponseBody
    @RequestMapping("/name/validate")
    public String userNameValidate(@RequestParam("userName")String userName, HttpSession session){
        String userName1 = (String)session.getAttribute("userName");
        if(userName != null && userName.equals(userName1)){
            return "true";
        }else{
            String s = userService.checkUserIsOccupied(userName);
            return s;
        }
    }

    /**
     * 用户退出功能
     * @return
     */
    @GetMapping("/loginout")
    public String userLoginOut(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        session.removeAttribute("userName");
        session.removeAttribute("userId");

        /*cookie不能直接删除，需要用相同路径的cookie覆盖掉*/
        /*cookie名字一样就行*/
        Cookie cookie = new Cookie("userId","");
        /*路径一定一致*/
        cookie.setPath(request.getContextPath()+"/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/index";
    }

    /**
     * 根据用户id进入个人主页，没有id时用session里的id
     * @param session
     * @param blogUserId
     * @param model
     * @return
     */
    @GetMapping("/home/{blogUserId}")
    public String userHomePage(HttpSession session,@PathVariable(value = "blogUserId",required = false)Integer blogUserId,
                               Model model){
        if(blogUserId == null || blogUserId.equals("")){
            blogUserId = (Integer) session.getAttribute("userId");
        }
        //Integer userId = (Integer) session.getAttribute("userId");

        if(blogUserId == null || blogUserId.equals("")){
            return "redirect:user/login";
        }else{
            String page = userService.getBlogUserAllInfosById(model, blogUserId);
            return page;
        }
    }

    /**
     * 获取头像直接写入输出流
     * @param useId
     * @param response
     */
    @GetMapping("/header/{userId}")
    public void getUserHeaderPic(@PathVariable("userId")Integer useId,HttpServletResponse response){
        userService.getUserHeader(useId,response);
    }

    /**
     * 改头像
     * @param
     * @param
     */
    @PostMapping("/header")/*/*/
    @ResponseBody
    public String updateUserHeaderPic(HttpSession session, @RequestParam("image") MultipartFile upload){

        int i=0;
        UserHeadPic userHeadPic = new UserHeadPic();
        userHeadPic.setUserId((Integer) session.getAttribute("userId"));
        if(upload != null) {
            try {
                userHeadPic.setUserHeaderPic(upload.getBytes());
            } catch (IOException e) {
                log.error("springmvc文件上传获取输入流出错");
                //e.printStackTrace();
            }
            i = userService.insertOrUpdateUserHeader(userHeadPic);
        }

        if(i>=1){
            return new Gson().toJson("success") ;
        }else{
            return new Gson().toJson("fail") ;
        }
    }

    /**
     * 更具用户及分页信息查找博客返回
     * @param userId
     * @param page
     * @param pageSize
     * @param model
     * @return
     */
    @GetMapping("/blogs/{userId}")
    public String getAllBlogs(@PathVariable("userId")Integer userId,Integer page,Integer pageSize,Model model){

        if(page == null || page.equals("")){
            page = 1;
        }
        if(pageSize == null || pageSize.equals("")){
            pageSize = 5;
        }

        return userService.getBlogsByUserId(userId,page,pageSize,model);
    }

    /**
     * 修改用户信息时先获取用户信息
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/info")
    public String getUserInfo(HttpSession session,Model model){

        Integer userId = (Integer)session.getAttribute("userId");

        if(userId == null || userId.equals("")){
            return "redirect:login";
        }else{
            BlogUser user = userService.getBlogUserById(userId);
            if(user == null){
                return "redirect:login";
            }else{
                model.addAttribute("user",user);
                return "userInfoEdit";
            }
        }
    }

    /**
     * 用户信息修改提交后的处理
     * @param blogUser
     * @param session
     * @return
     * @throws Exception
     */
    @PostMapping("/info")
    public String updateUserInfo(BlogUser blogUser,HttpSession session,@RequestParam("userBirthDayInfo")String userBirthDayInfo) throws Exception {

        Integer userId = (Integer)session.getAttribute("userId");

        blogUser.setUserBirthDay(new SimpleDateFormat("yyyy-MM-dd").parse(userBirthDayInfo));
        blogUser.setUserId(userId);
        int i = userService.updateUserInfo(blogUser);

        if(i >= 1){
            return "redirect:home/"+userId;
        }else{
            throw new Exception("用户更新出错");
        }
    }
}
