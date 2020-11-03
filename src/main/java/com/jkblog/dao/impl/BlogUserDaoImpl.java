package com.jkblog.dao.impl;

import com.jkblog.bean.BlogUser;
import com.jkblog.bean.BlogUserExample;
import com.jkblog.dao.BlogUserDao;
import com.jkblog.mapper.BlogUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogUserDaoImpl implements BlogUserDao {

    @Autowired
    private BlogUserMapper userMapper;

    @Override
    public BlogUser getBlogUserByUserName(String userName) {
        BlogUserExample example = new BlogUserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        List<BlogUser> users = userMapper.selectByExample(example);
        if(users.size()>=1){
            return users.get(0);
        }else{
            return null;
        }
    }

    @Override
    public BlogUser getBlogUserByUserId(Integer userId) {
        BlogUser blogUser = userMapper.selectByPrimaryKey(userId);
        return blogUser;
    }
}
