package com.jkblog.dao;

import com.jkblog.bean.BlogComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogCommentDao {

    public BlogComment getBlogCommentById(Integer BlogCommentId);

    public List<BlogComment> getBlogCommentsByBlogId(Integer BlogId);

    int insertComment(BlogComment comment);

    int updateCommentAttached(Integer commentId);

    int updateSonCount(Integer blogSonId);

    List<BlogComment> getCommentsByFather(Integer fatherId);

    int deleteCommentsByBlogId(Integer blogId);
}
