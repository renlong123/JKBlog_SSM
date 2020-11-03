package com.jkblog.dao;

import com.jkblog.bean.BlogLabel;
import com.jkblog.bean.BlogLabelMap;

import java.util.List;

public interface BlogLabelMapDao {

    public List<BlogLabelMap> getAllLabelByBlogId(Integer blogId);

    public int insertMaps(List<Integer> labelIds,Integer blogId);

    public int updateMaps(List<Integer> labelIds,Integer blogId);

    public int deleteMaps(Integer blogId);
}
