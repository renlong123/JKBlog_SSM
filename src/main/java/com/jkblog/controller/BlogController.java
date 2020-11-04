package com.jkblog.controller;

import com.jkblog.bean.Blog;
import com.jkblog.service.BlogService;
import com.jkblog.util.BlogVo;
import com.sun.xml.internal.bind.v2.runtime.ClassBeanInfoImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Controller
@RequestMapping("/blog")
@Slf4j
public class BlogController {

    @Autowired
    private BlogService blogService;

    /**
     * 根据是否有id进行插入或修改
     * @param blog
     * @param labelIds
     * @param session
     * @return
     * @throws Exception
     */
    @PostMapping("/edit")
    @ResponseBody
    public String blogInsert(Blog blog,@RequestParam("labelIds")List<Integer> labelIds, HttpSession session) throws Exception {

        log.debug(labelIds.toString());
        if(blog.getBlogId() != null){
            int i = blogService.updateBlog(blog, labelIds);
            if(i>= 1){
                return "success";
            }else{
                return "fail";
            }
        }else{
            int i = blogService.insertBlog(blog, labelIds, session);
            if(i >= 1){
                return "success";
            }else{
                return "fail";
            }
        }
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
