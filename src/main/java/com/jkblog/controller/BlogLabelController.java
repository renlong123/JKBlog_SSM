package com.jkblog.controller;

import com.google.gson.Gson;
import com.jkblog.bean.BlogLabel;
import com.jkblog.service.BlogLabelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/label")
@Slf4j
public class BlogLabelController {

    @Autowired
    private BlogLabelService blogLabelService;

    /**
     * 返回ajax请求的数据
     * */
    @ResponseBody
    @GetMapping("/get")
    public String getBlogLabels(){
        List<BlogLabel> blogLabels = blogLabelService.getBlogLabels();
        return new Gson().toJson(blogLabels);
    }
}
