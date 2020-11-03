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
    public int deleteBlog(Blog blog) {
        return 0;
    }
}
