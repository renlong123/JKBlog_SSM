package com.jkblog.dao.impl;

import com.jkblog.bean.Blog;
import com.jkblog.dao.BlogDao;
import com.jkblog.mapper.BlogMapper;
import com.jkblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public int insertBlog(Blog blog) {
        return 0;
    }

    @Override
    public int updateBlog(Blog blog) {
        return 0;
    }

    @Override
    public int deleteBlog(Blog blog) {
        return 0;
    }
}
