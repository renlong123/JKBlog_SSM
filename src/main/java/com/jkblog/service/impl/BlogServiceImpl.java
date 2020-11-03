package com.jkblog.service.impl;

import com.jkblog.bean.*;
import com.jkblog.dao.*;
import com.jkblog.mapper.BlogCategoryMapper;
import com.jkblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogDao blogDao;
    @Autowired
    private BlogCategoryDao blogCategoryDao;
    @Autowired
    private BlogCommentDao blogCommentDao;
    @Autowired
    private BlogLabelMapDao blogLabelMapDao;

    /**
     * 查找一篇博客并连带查找相关的分类，标签信息
     * @param blogId
     * @param model
     * @return
     */
    @Override
    public String getBlogAndAttachedInfos(Integer blogId, Model model) {

        Blog blog = blogDao.getBlogByBlogId(blogId);
        if(blog != null && blog.getBlogCategoryId()!= null){
            model.addAttribute("blog",blog);
            BlogCategory blogCategoryById = blogCategoryDao.getBlogCategoryById(blog.getBlogCategoryId());
            model.addAttribute("category",blogCategoryById);
            List<BlogLabelMap> allLabelByBlogId = blogLabelMapDao.getAllLabelByBlogId(blogId);
            model.addAttribute("labels",allLabelByBlogId);

            return "blogEdit";
        }
        return null;
    }
}
