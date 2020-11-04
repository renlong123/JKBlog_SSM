package com.jkblog.dao.impl;

import com.jkblog.bean.BlogLabel;
import com.jkblog.bean.BlogLabelExample;
import com.jkblog.dao.BlogLabelDao;
import com.jkblog.mapper.BlogLabelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogLabelDaoImpl implements BlogLabelDao {

    @Autowired
    private BlogLabelMapper blogLabelMapper;

    /**
     * 根据Id查询
     * @param blogLabelId
     * @return
     */
    @Override
    public BlogLabel getBlogLabelById(Integer blogLabelId) {

        BlogLabel blogLabel = blogLabelMapper.selectByPrimaryKey(blogLabelId);
        return blogLabel;

    }

    @Override
    public List<BlogLabel> getBlogLabels() {

        List<BlogLabel> blogLabels = blogLabelMapper.selectByExample(new BlogLabelExample());
        return blogLabels;

    }

    @Override
    public int insertBlogLabel(BlogLabel blogLabel) {
        int i = blogLabelMapper.insertSelective(blogLabel);
        return i;
    }

    @Override
    public int updateBlogLabel(BlogLabel blogLabel) {
        int i = blogLabelMapper.updateByPrimaryKeySelective(blogLabel);
        return i;
    }
}
