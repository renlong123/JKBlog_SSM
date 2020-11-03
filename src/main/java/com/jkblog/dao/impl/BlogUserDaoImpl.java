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

    /**
     * 通过用户名获取用户信息
     * @param userName
     * @return
     */
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

    /**
     * 通过用户id获取用户信息
     * @param userId
     * @return
     */
    @Override
    public BlogUser getBlogUserByUserId(Integer userId) {
        BlogUser blogUser = userMapper.selectByPrimaryKey(userId);
        return blogUser;
    }

    /**
     * 插入一个用户,某项信息没有就先不插入
     * @param blogUser
     * @return
     */
    @Override
    public int insertUser(BlogUser blogUser) {
        int i = userMapper.insertSelective(blogUser);
        return i;
    }
}
