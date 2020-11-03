package com.jkblog.dao;

import com.jkblog.bean.BlogLabel;

import java.util.List;

public interface BlogLabelDao {

    public BlogLabel getBlogLabelById(Integer blogLabelId);

    public List<BlogLabel> getBlogLabels();

}
