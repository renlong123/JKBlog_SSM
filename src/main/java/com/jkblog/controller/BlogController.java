package com.jkblog.controller;

import com.jkblog.bean.Blog;
import com.jkblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/edit")
    public String blogInsert(Blog blog){
/*        response.setHeader("content-type", "text/html;charset=UTF-8");
        String blogId = request.getParameter("blogId");
        String blogTitle = request.getParameter("blogTitle");
        Integer blogCategoryId = Integer.parseInt(request.getParameter("blogCategoryId"));
        String blogContent = request.getParameter("blogContent");

        Blog blog = new Blog();
        blog.setBlogTitle(blogTitle);
        blog.setBlogCategoryId(blogCategoryId);
        blog.setBlogContent(blogContent);
        blog.setBlogUserId((int)request.getSession().getAttribute("userId"));
        if(blogId == null){
            int i = blogService.insertBlog(blog);
            if(i>= 1){
                response.getWriter().write("success");
            }else{
                response.getWriter().write("fail");
            }
        }else{
            Integer blogSetId = Integer.parseInt(blogId);
            blog.setBlogId(blogSetId);
            int i = blogService.updateBlog(blog);
            if(i>= 1){
                response.getWriter().write("success");
            }else{
                response.getWriter().write("fail");
            }
        }*/
        return null;
    }

    /**
     * 根据传入参数确定是编辑还是插入
     * @param blogId
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/jump")
    public String blogJumpIn(@RequestParam(value = "blogId",required = false) Integer blogId, Model model) throws Exception {
        if(blogId == null){
            return "blogEdit";
        }else{
            String infos = blogService.getBlogAndAttachedInfos(blogId, model);
            if(infos != null){
                return "blogEdit";
            }else{
                throw new Exception("编辑的博客不存在");
            }
        }
    }


}
