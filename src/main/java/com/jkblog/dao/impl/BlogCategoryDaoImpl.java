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

    @Override
    public int updateCategoryCountById(Integer categoryId) {
        int i = blogCategoryMapper.categoryCountIncrement(categoryId);
        return i;
    }

    @Override
    public int changeCategoryCountById(Integer categoryIdNew, Integer categoryIdOld) {

        int i = blogCategoryMapper.categoryCountDecrement(categoryIdOld);
        int i1 = blogCategoryMapper.categoryCountIncrement(categoryIdNew);
        return i+i1;
    }

    @Override
    public int insertCategory(BlogCategory blogCategory) {
        int i = blogCategoryMapper.insertSelective(blogCategory);
        return i;
    }

    @Override
    public int updateCategory(BlogCategory blogCategory) {
        int i = blogCategoryMapper.updateByPrimaryKeySelective(blogCategory);
        return i;
    }
}
