package com.jkblog.service.impl;

import com.jkblog.bean.Blog;
import com.jkblog.bean.BlogExample;
import com.jkblog.mapper.BlogMapper;
import com.jkblog.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class IndexServiceImpl implements IndexService {

    @Autowired
    private BlogMapper blogMapper;

    /**
     * 该方法获取最热博客，返回给首页
     * @return
     */
    @Override
    public List<Blog> getBriefHotBlogs() {

        List<Blog> blogs = blogMapper.selectHotBlogs(10);
        return blogs;

    }
}
