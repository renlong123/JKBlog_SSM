package com.jkblog.service.impl;

import com.google.gson.Gson;
import com.jkblog.bean.BlogCategory;
import com.jkblog.dao.BlogCategoryDao;
import com.jkblog.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private BlogCategoryDao blogCategoryDao;

    /**
     * 直接返回所有分类
     * @return
     */
    @Override
    public String getCategories() {
        List<BlogCategory> categories = blogCategoryDao.getCategories();
        log.debug(categories.toString());
        return new Gson().toJson(categories);
    }
}
