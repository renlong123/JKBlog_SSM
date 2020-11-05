package com.jkblog.controller;

import com.google.gson.Gson;
import com.jkblog.bean.BlogComment;
import com.jkblog.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    @ResponseBody
    public String addComment(BlogComment blogComment, HttpSession session){

        Date commentTime = new Date();
        Integer commentUserId = (Integer)session.getAttribute("userId");
        String commentUserName = (String)session.getAttribute("userName");

        blogComment.setBlogCommentTime(commentTime);
        blogComment.setBlogCommentUserId(commentUserId);
        blogComment.setBlogCommentUserName(commentUserName);

        int i = commentService.insertCommentAndAttachedInfo(blogComment);

        if(i>=1){
            return "success";
        }else{
            return "fail";
        }
    }

    @GetMapping("/get/{fatherId}")
    @ResponseBody
    public String getComments(@PathVariable("fatherId") Integer fatherId){

        List<BlogComment> commentsByFather = commentService.getCommentsByFather(fatherId);

        return new Gson().toJson(commentsByFather);

    }

}
