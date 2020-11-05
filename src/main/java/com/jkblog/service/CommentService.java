package com.jkblog.service;

import com.jkblog.bean.BlogComment;

import java.util.List;

public interface CommentService {

    public int insertCommentAndAttachedInfo(BlogComment blogComment);

    List<BlogComment> getCommentsByFather(Integer fatherId);
}
