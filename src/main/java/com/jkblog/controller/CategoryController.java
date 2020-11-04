package com.jkblog.controller;

import com.jkblog.bean.BlogCategory;
import com.jkblog.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/insert")
    @ResponseBody
    public String insertCategory(BlogCategory blogCategory){
        int result = 0;
        Integer categoryId = blogCategory.getCategoryId();

        if(categoryId == null || categoryId.equals("")){
            result = categoryService.insertCategory(blogCategory);
        }else{
            result = categoryService.updateCategory(blogCategory);
        }

        if(result >= 1){
            return "success";
        }else{
            return "fail";
        }
    }
}
