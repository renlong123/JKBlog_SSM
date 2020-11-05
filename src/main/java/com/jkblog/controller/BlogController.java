package com.jkblog.controller;

import com.google.gson.Gson;
import com.jkblog.bean.Blog;
import com.jkblog.service.BlogService;
import com.jkblog.util.BlogVo;
import com.jkblog.util.ImageResult;
import com.sun.xml.internal.bind.v2.runtime.ClassBeanInfoImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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

    @RequestMapping("/delete/{blogId}")
    public String blogDelete(@PathVariable("blogId") Integer blogId,HttpSession session){
        int i = blogService.deleteBlogAndAttachedInfo(blogId);
        return "redirect:/user/home/"+session.getAttribute("userId");
    }

    /**
     * 获取上传的所有文件，改变文件名，存放至本地磁盘，并将路径映射发回前端。
     * @param files
     * @return
     */
    @PostMapping("/image")
    @ResponseBody
    public String uploadImages(@RequestParam("images")MultipartFile[] files,@PathVariable(value = "blogId",required = false)Integer blogId){

        return blogService.uploadImages(files,blogId);
    }

    /**
     * 获取博客详细信息。
     * @param
     * @return
     */
    @GetMapping("/detail/{blogId}")
    public String getBlogAllInfos(@PathVariable(value = "blogId",required = false)Integer blogId,Model model){

        return blogService.getBlogAndAttachedInfosIncludeComment(blogId,model);
    }

}
