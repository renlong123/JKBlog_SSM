package com.jkblog.dao.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.jkblog.bean.Blog;
import com.jkblog.bean.BlogExample;
import com.jkblog.dao.BlogDao;
import com.jkblog.mapper.BlogMapper;
import com.jkblog.service.BlogService;
import com.jkblog.util.ImageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class BlogDaoImpl implements BlogDao {

    @Autowired
    private BlogMapper blogMapper;

    /**
     * 根据id查找博客
     * @param blogId
     * @return
     */
    @Override
    public Blog getBlogByBlogId(Integer blogId) {
        Blog blog = blogMapper.selectByPrimaryKey(blogId);
        return blog;
    }

    @Override
    public List<Blog> getAllBlogs() {
        return null;
    }

    /**
     * 插入博客
     * @param blog
     * @return
     */
    @Override
    public int insertBlog(Blog blog) {
        int insert = blogMapper.insertSelective(blog);
        return insert;
    }

    @Override
    public int updateBlog(Blog blog) {
        int i = blogMapper.updateByPrimaryKeySelective(blog);
        return i;
    }

    @Override
    public int deleteBlog(Integer blogId) {
        blogMapper.deleteByPrimaryKey(blogId);
        return 0;
    }

    @Override
    public PageInfo getBlogsByUserId(Integer userId,Integer page,Integer pageSize) {
        BlogExample example = new BlogExample();
        example.createCriteria().andBlogUserIdEqualTo(userId);
        PageHelper.startPage(page, pageSize);
        List<Blog> blogs = blogMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(blogs);
        return pageInfo;
    }

    @Override
    public int insertOrUpdateImages(Integer id, String imagesPath) {

        return blogMapper.insertOrUpdateImages(id,imagesPath);
    }

    @Override
    public String getImagesById(Integer blogId) {
        String imagesById = blogMapper.getImagesById(blogId);
        return imagesById;
    }

    @Override
    public int incrementBlogCommentsCount(Integer blogId) {
        int i = blogMapper.incrementBlogCommentsCount(blogId);
        return i;
    }

    @Override
    public int decrementBlogCommentsCount(Integer blogId) {
        int i = blogMapper.decrementBlogCommentsCount(blogId);
        return i;
    }


}
