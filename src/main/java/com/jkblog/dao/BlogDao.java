package com.jkblog.dao;

import com.jkblog.bean.Blog;

import java.util.List;

public interface BlogDao {

    public Blog getBlogByBlogId(Integer blogId);

    public List<Blog> getAllBlogs();

    public int insertBlog(Blog blog);

    public int updateBlog(Blog blog);

    public int deleteBlog(Blog blog);

}
