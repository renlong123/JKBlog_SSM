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

    @Override
    public int insertMaps(List<Integer> labelIds, Integer blogId) {
        for(Integer labelId: labelIds){
            BlogLabelMap map = new BlogLabelMap();
            map.setBlogId(blogId);
            map.setLabelId(labelId);
            int insert = blogLabelMapMapper.insert(map);
            if(insert < 1){
                return 0;
            }
        }

        return labelIds.size();
    }

    @Override
    public int updateMaps(List<Integer> labelIds, Integer blogId) {
        int i = deleteMaps(blogId);
        int i1 = insertMaps(labelIds, blogId);
        return i+i1;
    }

    /**
     * 删除
     * @param blogId
     * @return
     */
    @Override
    public int deleteMaps(Integer blogId) {
        BlogLabelMapExample example = new BlogLabelMapExample();
        example.createCriteria().andBlogIdEqualTo(blogId);
        int i = blogLabelMapMapper.deleteByExample(example);
        return i;
    }
}
