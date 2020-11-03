package com.jkblog.controller;

import com.jkblog.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/category")
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 返回json串
     * @return
     */
    @GetMapping("/get")
    @ResponseBody
    public String getCategories(){
        String categories = categoryService.getCategories();
        return categories;
    }
}
