package com.jkblog.service;

import com.jkblog.bean.Blog;
import com.jkblog.bean.BlogUser;
import com.jkblog.bean.UserHeadPic;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface UserService {

    public String userLogin(String userName, String userPassword, String rememberMe,
                            HttpServletRequest request, HttpServletResponse response);

    public String getUserNameByUserId(Integer userId);

    public int insertUser(BlogUser blogUser);

    public String checkUserIsOccupied(String userName);

    public BlogUser getBlogUserById(Integer blogUserId);

    public String getBlogUserAllInfosById(Model model, Integer blogUserId);

    public void getUserHeader(Integer userId,HttpServletResponse response);

    public int insertOrUpdateUserHeader(UserHeadPic userHeadPic);

    public String getBlogsByUserId(Integer userId, Integer page, Integer pageSize,Model model);

    public int updateUserInfo(BlogUser user);
}
