package com.jkblog.service;

import com.jkblog.bean.Blog;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface BlogService {

    public String getBlogAndAttachedInfos(Integer blogId, Model model);

    public int insertBlog(Blog blog,List<Integer> labelIds, HttpSession session);

    public int updateBlog(Blog blog ,List<Integer> labelIds) throws Exception;



}
