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
     * @param
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

    @Override
    public int insertComment(BlogComment comment) {
        int i = blogCommentMapper.insertSelective(comment);
        return i;
    }

    @Override
    public int updateCommentAttached(Integer commentId) {
        return 0;
    }

    @Override
    public int updateSonCount(Integer blogSonId) {
        int i = blogCommentMapper.updateSonCount(blogSonId);
        return i;
    }

    @Override
    public List<BlogComment> getCommentsByFather(Integer fatherId) {
        List<BlogComment> commentsByFather = blogCommentMapper.getCommentsByFather(fatherId);
        return commentsByFather;
    }

    @Override
    public int deleteCommentsByBlogId(Integer blogId) {
        BlogCommentExample example = new BlogCommentExample();
        example.createCriteria().andBlogCommentBlogIdEqualTo(blogId);
        int i = blogCommentMapper.deleteByExample(example);
        return i;
    }
}
