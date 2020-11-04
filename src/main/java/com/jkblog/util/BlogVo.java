package com.jkblog.util;

import com.jkblog.bean.Blog;

import java.util.List;

public class BlogVo {

    Blog blog;
    List<Integer> labelIds;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<Integer> getLabelIds() {
        return labelIds;
    }

    public void setLabelIds(List<Integer> labelIds) {
        this.labelIds = labelIds;
    }
}
