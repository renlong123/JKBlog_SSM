package com.jkblog.dao.impl;

import com.jkblog.bean.BlogComment;
import com.jkblog.bean.BlogCommentExample;
import com.jkblog.dao.BlogCommentDao;
import com.jkblog.mapper.BlogCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogCommentDaoImpl implements BlogCommentDao{

    @Autowired
    private BlogCommentMapper blogCommentMapper;

    /**
     * 返回评论
     * @param blogCommentId
     * @return
     */
    @Override
    public BlogComment getBlogCommentById(Integer blogCommentId) {

        BlogComment blogComment = blogCommentMapper.selectByPrimaryKey(blogCommentId);

        return blogComment;
    }

    /**
     * 根据博客Id返回一级评论
     * @param BlogId
     * @return
     */
    @Override
    public List<BlogComment> getBlogCommentsByBlogId(Integer blogId) {
        BlogCommentExample example = new BlogCommentExample();
        /*查找一级评论*/
        example.createCriteria().andBlogCommentBlogIdEqualTo(blogId).andBlogCommentFatherEqualTo(0);
        List<BlogComment> blogComments = blogCommentMapper.selectByExample(example);
        return blogComments;
    }
}
