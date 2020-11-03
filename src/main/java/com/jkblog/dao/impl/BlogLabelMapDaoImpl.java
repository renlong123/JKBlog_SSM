package com.jkblog.dao.impl;

import com.jkblog.bean.BlogLabel;
import com.jkblog.bean.BlogLabelMap;
import com.jkblog.bean.BlogLabelMapExample;
import com.jkblog.dao.BlogLabelMapDao;
import com.jkblog.mapper.BlogLabelMapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogLabelMapDaoImpl implements BlogLabelMapDao {

    @Autowired
    private BlogLabelMapMapper blogLabelMapMapper;

    /**
     * 获取博客的所有label信息
     * @param blogId
     * @return
     */
    @Override
    public List<BlogLabelMap> getAllLabelByBlogId(Integer blogId) {

        List<BlogLabelMap> labelMaps = blogLabelMapMapper.selectBlogLabelMapWithLabel(blogId);
        return labelMaps;
    }
}
