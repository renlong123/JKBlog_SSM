package com.jkblog.dao.impl;

import com.jkblog.bean.BlogCategory;
import com.jkblog.bean.BlogCategoryExample;
import com.jkblog.dao.BlogCategoryDao;
import com.jkblog.mapper.BlogCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogCategoryDaoImpl implements BlogCategoryDao {

    @Autowired
    private BlogCategoryMapper blogCategoryMapper;

    @Override
    public BlogCategory getBlogCategoryById(Integer blogCategoryId) {

        BlogCategory blogCategory = blogCategoryMapper.selectByPrimaryKey(blogCategoryId);
        return blogCategory;
    }

    /**
     * 返回所有分类
     * @return
     */
    @Override
    public List<BlogCategory> getCategories() {
        List<BlogCategory> blogCategories = blogCategoryMapper.selectByExample(new BlogCategoryExample());
        return blogCategories;
    }
}
