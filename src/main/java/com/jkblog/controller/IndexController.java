package com.jkblog.controller;


import com.jkblog.bean.Blog;
import com.jkblog.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private IndexService indexService;

    /**跳转至主页的方法
     * */
    @GetMapping({"/index","/","/hello"})
    public String index(HttpServletRequest request){
        log.debug("进入index一次");
        List<Blog> hotBlogs = indexService.getBriefHotBlogs();
        request.setAttribute("blogs",hotBlogs);
        return "index";
    }

    @RequestMapping("/error/{errorId}")
    public String errorHandler(@PathVariable("errorId")String errorId) throws Exception {
        if(errorId.equals("404")){
            throw new Exception("404");
        }else if(errorId.equals("500")){
            throw new Exception("500");
        }else{
            throw new Exception("出错了");
        }
    }

}
