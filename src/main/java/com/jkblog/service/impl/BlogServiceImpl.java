package com.jkblog.service.impl;

import com.google.gson.Gson;
import com.jkblog.bean.*;
import com.jkblog.controller.BlogController;
import com.jkblog.dao.*;
import com.jkblog.mapper.BlogCategoryMapper;
import com.jkblog.service.BlogService;
import com.jkblog.util.ImageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
@Slf4j
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogDao blogDao;
    @Autowired
    private BlogCategoryDao blogCategoryDao;
    @Autowired
    private BlogCommentDao blogCommentDao;
    @Autowired
    private BlogLabelMapDao blogLabelMapDao;
    @Autowired
    private BlogUserDao blogUserDao;

    /*虚拟路径的映射*/
    public static final String localUrl;
    public static final String mappedUrl;

    static {
        Properties properties = new Properties();
        InputStream inputStream = BlogController.class.getClassLoader().getResourceAsStream("path.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        localUrl = properties.getProperty("localurl");
        mappedUrl = properties.getProperty("mappedurl");
    }

    /**
     * 查找一篇博客并连带查找相关的分类，标签信息
     * @param blogId
     * @param model
     * @return
     */
    @Override
    public String getBlogAndAttachedInfos(Integer blogId, Model model) {

        Blog blog = blogDao.getBlogByBlogId(blogId);
        if(blog != null && blog.getBlogCategoryId()!= null){
            model.addAttribute("blog",blog);
            BlogCategory blogCategoryById = blogCategoryDao.getBlogCategoryById(blog.getBlogCategoryId());
            model.addAttribute("category",blogCategoryById);
            List<BlogLabelMap> allLabelByBlogId = blogLabelMapDao.getAllLabelByBlogId(blogId);
            model.addAttribute("labels",allLabelByBlogId);

            return "blogEdit";
        }
        return null;
    }

    @Override
    @Transactional(timeout = 3,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int insertBlog(Blog blog,List<Integer> labelIds, HttpSession session) throws Exception {

        blog.setBlogEditTime(new Date());
        blog.setBlogUserId((Integer)session.getAttribute("userId"));
        blog.setBlogBriefContent(blog.getBlogContent().substring(0,
                blog.getBlogContent().length()>50?50:blog.getBlogContent().length()).
                replaceAll("<","").replaceAll(">",""));
        /*插入博客*/
        int i = blogDao.insertBlog(blog);
        if(i!=1){
            throw new Exception("博客插入错误");
        }
        /*更新博客标签*/
        int i1 = blogLabelMapDao.insertMaps(labelIds, blog.getBlogId());
        /*更新所属分类下的文章数目*/
        int i2 = blogCategoryDao.updateCategoryCountById(blog.getBlogCategoryId());
        if(i!=1){
            throw new Exception("博客插入错误");
        }
        /*更新作者文章数*/
        int i3 = blogUserDao.incrementUserBlogsCountById(blog.getBlogUserId());
        if(i!=1){
            throw new Exception("博客插入错误");
        }

        return i+i1+i2+i3;
    }

    @Override
    public int updateBlog(Blog blog ,List<Integer> labelIds) throws Exception {
        blog.setBlogEditTime(new Date());
        //blog.setBlogUserId((Integer)session.getAttribute("userId"));
        blog.setBlogBriefContent(blog.getBlogContent().substring(0,
                blog.getBlogContent().length()>50?50:blog.getBlogContent().length()).
                replaceAll("<","").replaceAll(">",""));
        /*插入博客*/
        int i = blogDao.updateBlog(blog);
        /*更新博客标签*/
        int i1 = blogLabelMapDao.updateMaps(labelIds, blog.getBlogId());
        /*更新所属分类下的文章数目*/
        int i2 = 0;
        Blog blogByBlogId = blogDao.getBlogByBlogId(blog.getBlogId());
        if(blogByBlogId.getBlogCategoryId() != blog.getBlogCategoryId()){
            i2 = blogCategoryDao.changeCategoryCountById(blog.getBlogCategoryId(),blogByBlogId.getBlogCategoryId());
            if(i2%2 != 0){
                throw new Exception("更新错误");
            }
        }
        return i+i1+i2;
    }

    @Override
    public String uploadImages(MultipartFile[] files,Integer blogId) {
        ImageResult result = new ImageResult();
        List<String> data = new ArrayList<>();
        for(
                MultipartFile file: files){
            if(file != null){
                String originalName = file.getOriginalFilename();
                String[] lists = originalName.split("\\.");

                //新名字
                String newName = UUID.randomUUID()+"_"+System.currentTimeMillis()+"."+lists[lists.length-1];
                log.debug("新名字为："+newName);

                /*本地磁盘路径*/
                File localUrlAddr = new File(localUrl+"/"+lists[lists.length-1]);
                if(!localUrlAddr.exists()){
                    localUrlAddr.mkdirs();
                }
                /*可以通过localhost:8080/fianlMappedUrl访问finalUrl路径下的文件*/
                String finalUrl = localUrlAddr +"/"+newName;
                String fianlMappedUrl = mappedUrl + "/"+lists[lists.length-1]+"/"+newName;

                try {
                    file.transferTo(new File(finalUrl));
                } catch (IOException e) {
                    log.error("文件保存出错");
                }

                data.add(fianlMappedUrl);
            }
        }
        if(blogId == null || blogId.equals("")){

        }else{
            updateImage(data,blogId);
        }
        result.setErrno(0);
        result.setData(data);
        return new Gson().toJson(result);
    }

    public int updateImage(List<String> imagesPath,Integer blogId){
        Gson gson = new Gson();
        List<String> original = gson.fromJson(blogDao.getImagesById(blogId),List.class);
        if(original != null){
            original.addAll(imagesPath);
        }else{
            original = imagesPath;
        }
        String s = gson.toJson(original);
        int i = blogDao.insertOrUpdateImages(blogId, s);
        return i;
    }

    /**
     * 返回所有信息。
     * @param blogId
     * @param model
     * @return
     */
    @Override
    public String getBlogAndAttachedInfosIncludeComment(Integer blogId,Model model){

        String blogAndAttachedInfos = getBlogAndAttachedInfos(blogId, model);
        Blog attribute = (Blog)model.getAttribute("blog");
        if(blogAndAttachedInfos != null && attribute.getBlogId() != null){
            List<BlogComment> blogCommentsByBlogId = blogCommentDao.getBlogCommentsByBlogId(attribute.getBlogId());
            model.addAttribute("blogComments",blogCommentsByBlogId);
            BlogUser blogUserByUserId = blogUserDao.getBlogUserByUserId(attribute.getBlogUserId());
            model.addAttribute("user",blogUserByUserId);
        }

        if(blogAndAttachedInfos == null){
            return null;
        }else {
            return "blogDetail";
        }
    }

    @Override
    public int deleteBlogAndAttachedInfo(Integer blogId) {

        /*
        * 需要删除 博客信息，分类数目减一，所有评论，标签映射表中的数据删除，用户博客数目减一，
        * */
        Blog blog = blogDao.getBlogByBlogId(blogId);
        if(blog == null){
            return 0;
        }else{
            int i = blogDao.deleteBlog(blogId);
            int i1 = blogCategoryDao.decrementCategoryById(blog.getBlogCategoryId());
            int i2 = blogCommentDao.deleteCommentsByBlogId(blogId);
            int i3 = blogLabelMapDao.deleteMaps(blogId);
            int i4 = blogUserDao.decrementUserBlogsCountById(blog.getBlogUserId());
            return i+i1+i2+i3+i4;
        }
    }
}
