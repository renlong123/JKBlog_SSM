package com.jkblog.service;

import com.jkblog.bean.Blog;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface BlogService {

    public String getBlogAndAttachedInfos(Integer blogId, Model model);

    public int insertBlog(Blog blog,List<Integer> labelIds, HttpSession session);

    public int updateBlog(Blog blog ,List<Integer> labelIds) throws Exception;

    String uploadImages(MultipartFile[] files,Integer blogId);

    public String getBlogAndAttachedInfosIncludeComment(Integer blogId,Model model);

    int deleteBlogAndAttachedInfo(Integer blogId);
}
