package com.jkblog.service.impl;

import com.jkblog.bean.BlogUser;
import com.jkblog.dao.BlogUserDao;
import com.jkblog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private BlogUserDao userDao;

    /**
     * 处理用户登录，根据不同请求跳转到不同的页面
     * @param userName
     * @param userPassword
     * @param rememberMe
     * @param request
     * @param response
     * @return
     */
    @Override
    public String userLogin(String userName, String userPassword, String rememberMe,
                            HttpServletRequest request, HttpServletResponse response) {

        if(userName != null && !userName.equals("")){

            BlogUser blogUserByUserName = userDao.getBlogUserByUserName(userName);

            if(blogUserByUserName != null && blogUserByUserName.getUserPassword()!= null &&
                    blogUserByUserName.getUserPassword().equals(userPassword)){
                log.debug("[{}]登录成功",userName);
                request.getSession().setAttribute("userName",userName);
                request.getSession().setAttribute("userId",blogUserByUserName.getUserId());
                /*将用户添加至cookie免登录*/
                if(rememberMe != null && rememberMe.equals("rememberMe")){
                    /*返回cookie所有路径都用，*/
                    Cookie cookie = new Cookie("userId",blogUserByUserName.getUserId().toString());
                    cookie.setMaxAge(7*24*60*60);
                    cookie.setPath(request.getContextPath()+"/");
                    response.addCookie(cookie);
                }
                /*返回主页*/
                return "redirect:index";
            }else{
                log.debug("[{}]登录失败，用户名不存在或与密码不匹配",userName);
                request.setAttribute("loginTips","用户名不存在或与密码不匹配");
                return "userLogin";
            }
        }else{
            log.debug("[{}]登录失败，用户名不合法",userName);
            request.setAttribute("loginTips","用户名不合法");
            return "userLogin";
        }
    }

    /**
     * 根据用户id获取用户
     * @param userId
     * @return
     */
    @Override
    public String getUserNameByUserId(Integer userId) {

        BlogUser blogUserByUserId = userDao.getBlogUserByUserId(userId);

        if(blogUserByUserId == null){
            return "";
        }else{
            return blogUserByUserId.getUserName();
        }
    }

    /**
     * 根据输入的user进行插入到数据库
     * @param blogUser
     * @return
     */
    @Override
    public int insertUser(BlogUser blogUser) {
        int i = userDao.insertUser(blogUser);
        return i;
    }

    /**
     * 根据输入用户名检测用户是否已经有了
     * @param userName
     * @return
     */
    @Override
    public String checkUserIsOccupied(String userName) {
        BlogUser blogUserInDataBase = userDao.getBlogUserByUserName(userName);
        if(blogUserInDataBase != null && blogUserInDataBase.getUserId()!= null && blogUserInDataBase.getUserName() != null){
            return "true";
        }else {
            return "false";
        }
    }

}
