package com.jkblog.service.impl;

import com.jkblog.bean.*;
import com.jkblog.dao.*;
import com.jkblog.mapper.BlogCategoryMapper;
import com.jkblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Date;
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

    @Override
    public int insertBlog(Blog blog,List<Integer> labelIds, HttpSession session) {

        blog.setBlogEditTime(new Date());
        blog.setBlogUserId((Integer)session.getAttribute("userId"));
        blog.setBlogBriefContent(blog.getBlogContent().substring(0,
                blog.getBlogContent().length()>50?50:blog.getBlogContent().length()).
                replaceAll("<","").replaceAll(">",""));
        /*插入博客*/
        int i = blogDao.insertBlog(blog);
        /*更新博客标签*/
        int i1 = blogLabelMapDao.insertMaps(labelIds, blog.getBlogId());
        /*更新所属分类下的文章数目*/
        int i2 = blogCategoryDao.updateCategoryCountById(blog.getBlogCategoryId());

        return i+i1+i2;
    }

    @Override
    public int updateBlog(Blog blog ,List<Integer> labelIds) throws Exception {
        blog.setBlogEditTime(new Date());
        //blog.setBlogUserId((Integer)session.getAttribute("userId"));
        blog.setBlogBriefContent(blog.getBlogContent().substring(0,
                blog.getBlogContent().length()>50?50:blog.getBlogContent().length()).
                replaceAll("<","").replaceAll(">",""));
        /*插入博客*/
        int i = blogDao.updateBlog(blog);
        /*更新博客标签*/
        int i1 = blogLabelMapDao.updateMaps(labelIds, blog.getBlogId());
        /*更新所属分类下的文章数目*/
        int i2 = 0;
        Blog blogByBlogId = blogDao.getBlogByBlogId(blog.getBlogId());
        if(blogByBlogId.getBlogCategoryId() != blog.getBlogCategoryId()){
            i2 = blogCategoryDao.changeCategoryCountById(blog.getBlogCategoryId(),blogByBlogId.getBlogCategoryId());
            if(i2%2 != 0){
                throw new Exception("更新错误");
            }
        }
        return i+i1+i2;
    }
}
