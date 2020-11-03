package com.jkblog.dao;

import com.jkblog.bean.BlogUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;


public interface BlogUserDao {

    public BlogUser getBlogUserByUserName(String userName);

    public BlogUser getBlogUserByUserId(Integer userId);

    public int insertUser(BlogUser blogUser);
}
