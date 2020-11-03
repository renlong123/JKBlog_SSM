package com.jkblog.service;

import com.jkblog.bean.Blog;

import java.util.List;

public interface IndexService {

    /*首页获取排行靠前的博客，只要简要信息即可*/
    public List<Blog> getBriefHotBlogs();

}
