package com.jkblog.service.impl;

import com.jkblog.bean.BlogLabel;
import com.jkblog.dao.BlogLabelDao;
import com.jkblog.service.BlogLabelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class BlogLabelServiceImpl implements BlogLabelService {

    @Autowired
    private BlogLabelDao blogLabelDao;

    @Override
    public List<BlogLabel> getBlogLabels() {
        List<BlogLabel> blogLabels = blogLabelDao.getBlogLabels();
        return blogLabels;
    }
}
