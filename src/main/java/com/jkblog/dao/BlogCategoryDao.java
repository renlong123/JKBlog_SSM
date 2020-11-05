package com.jkblog.dao;

import com.jkblog.bean.BlogCategory;

import java.util.List;

public interface BlogCategoryDao {

    public BlogCategory getBlogCategoryById(Integer blogCategoryId);

    public List<BlogCategory> getCategories();

    public int updateCategoryCountById(Integer categoryId);

    public int changeCategoryCountById(Integer categoryIdNew,Integer categoryIdOld);

    public int insertCategory(BlogCategory blogCategory);

    public int updateCategory(BlogCategory blogCategory);

    int decrementCategoryById(Integer categoryId);
}
