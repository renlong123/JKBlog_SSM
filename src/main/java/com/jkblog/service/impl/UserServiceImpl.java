package com.jkblog.service.impl;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.jkblog.bean.Blog;
import com.jkblog.bean.BlogUser;
import com.jkblog.bean.UserHeadPic;
import com.jkblog.dao.BlogDao;
import com.jkblog.dao.BlogUserDao;
import com.jkblog.mapper.UserHeaderMapper;
import com.jkblog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private BlogUserDao userDao;

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private UserHeaderMapper userHeaderMapper;

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
                return "redirect:/index";
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

    @Override
    public BlogUser getBlogUserById(Integer blogUserId) {
        BlogUser blogUser = userDao.getBlogUserByUserId(blogUserId);
        return blogUser;
    }

    /**
     * 查找用户信息及相关的博客信息
     * @param model
     * @param blogUserId
     * @return
     */
    @Override
    public String getBlogUserAllInfosById(Model model, Integer blogUserId) {
        BlogUser blogUserById = getBlogUserById(blogUserId);
        model.addAttribute("user",blogUserById);
        PageInfo userBlogs = blogDao.getBlogsByUserId(blogUserId, 1, 5);
        model.addAttribute("blogs",userBlogs);
        return "userHomePage";
    }

    @Override
    public void getUserHeader(Integer userId,HttpServletResponse response) {
        UserHeadPic userHeadPicById = userHeaderMapper.getUserHeadPicById(userId);
        byte[] headerPic = userHeadPicById.getUserHeaderPic();
        /*写出到页面*/
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            out.write(headerPic);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int insertOrUpdateUserHeader(UserHeadPic userHeadPic) {

        int i = userDao.insertOrUpdateHeader(userHeadPic);
        return i;
    }

    @Override
    public String getBlogsByUserId(Integer userId, Integer page, Integer pageSize,Model model) {
        PageInfo blogsByUserId = blogDao.getBlogsByUserId(userId, page, pageSize);
        model.addAttribute("pageInfo",blogsByUserId);
        model.addAttribute("pageUserId",userId);
        return "blogPages";
    }

    @Override
    public int updateUserInfo(BlogUser user) {
        int i = userDao.updateUserInfo(user);
        return i;
    }

}
