package com.jkblog.service;

import com.jkblog.bean.BlogLabel;

import java.util.List;

public interface BlogLabelService {

    public List<BlogLabel> getBlogLabels();

    public int insertBlogLabel(BlogLabel blogLabel);

    public int updateBlogLabel(BlogLabel blogLabel);
}
