package com.jkblog.dao;

import com.github.pagehelper.PageInfo;
import com.jkblog.bean.Blog;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BlogDao {

    public Blog getBlogByBlogId(Integer blogId);

    public List<Blog> getAllBlogs();

    public int insertBlog(Blog blog);

    public int updateBlog(Blog blog);

    public int deleteBlog(Integer blogId);

    public PageInfo getBlogsByUserId(Integer userId, Integer page, Integer pageSize);

    int insertOrUpdateImages(Integer id,String imagesPath);

    String getImagesById(Integer blogId);

    int incrementBlogCommentsCount(Integer blogId);

    int decrementBlogCommentsCount(Integer blogId);

}
