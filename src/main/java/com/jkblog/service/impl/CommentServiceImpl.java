package com.jkblog.service.impl;

import com.jkblog.bean.BlogComment;
import com.jkblog.dao.BlogCommentDao;
import com.jkblog.dao.BlogDao;
import com.jkblog.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private BlogCommentDao blogCommentDao;
    @Autowired
    private BlogDao blogDao;

    @Override
    public int insertCommentAndAttachedInfo(BlogComment blogComment) {

        int result = 0;
        //*插入评论
        int i = blogCommentDao.insertComment(blogComment);

        if(i >= 1) {
            int i1 = blogDao.incrementBlogCommentsCount(blogComment.getBlogCommentBlogId());
            if(i1 >= 1) {
                if(blogComment.getBlogCommentFather() != 0) {
                    int i2 = blogCommentDao.updateSonCount(blogComment.getBlogCommentBlogSonId());
                    result = i2;
                }else{
                    result = 1;
                }
            }else{
                result = 0;
            }
        }else{
            result = 0;
        }

        return result;
    }

    @Override
    public List<BlogComment> getCommentsByFather(Integer fatherId) {
        List<BlogComment> commentsByFather = blogCommentDao.getCommentsByFather(fatherId);
        return commentsByFather;
    }
}
