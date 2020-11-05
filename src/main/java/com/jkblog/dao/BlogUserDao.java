package com.jkblog.dao;

import com.jkblog.bean.BlogUser;
import com.jkblog.bean.UserHeadPic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;


public interface BlogUserDao {

    public BlogUser getBlogUserByUserName(String userName);

    public BlogUser getBlogUserByUserId(Integer userId);

    public int insertUser(BlogUser blogUser);

    public int insertUserHeaderPic(UserHeadPic userHeadPic);

    public int updateUserHeaderPic(UserHeadPic userHeadPic);

    public UserHeadPic getUserHeaderPicById(Integer userId);

    public int insertOrUpdateHeader(UserHeadPic userHeadPic);

    //public BlogUser getBlogUserById(Integer blogUserId);
    public int updateUserInfo(BlogUser user);

    int decrementUserBlogsCountById(Integer userId);
    int incrementUserBlogsCountById(Integer userId);
}
