package com.jkblog.service;

import com.jkblog.bean.BlogCategory;

public interface CategoryService {

    public String getCategories();

    public int updateCategory(BlogCategory blogCategory);

    public int insertCategory(BlogCategory blogCategory);
}
