package com.jkblog.dao;

import com.jkblog.bean.BlogComment;

import java.util.List;

public interface BlogCommentDao {

    public BlogComment getBlogCommentById(Integer BlogCommentId);

    public List<BlogComment> getBlogCommentsByBlogId(Integer BlogId);

}
