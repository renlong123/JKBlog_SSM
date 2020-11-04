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

    /**
     * 更新分类，没有的项不更新
     * @param blogCategory
     * @return
     */
    @Override
    public int updateCategory(BlogCategory blogCategory) {
        int i = blogCategoryDao.updateCategory(blogCategory);
        return i;
    }

    /**
     * 插入分类
     * @param blogCategory
     * @return
     */
    @Override
    public int insertCategory(BlogCategory blogCategory) {
        int i = blogCategoryDao.insertCategory(blogCategory);
        return i;
    }
}
