package com.jkblog.mapper;

import com.jkblog.bean.BlogLabelMap;
import com.jkblog.bean.BlogLabelMapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogLabelMapMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bloglabelmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    long countByExample(BlogLabelMapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bloglabelmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    int deleteByExample(BlogLabelMapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bloglabelmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    int deleteByPrimaryKey(Integer blogLabelId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bloglabelmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    int insert(BlogLabelMap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bloglabelmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    int insertSelective(BlogLabelMap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bloglabelmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    List<BlogLabelMap> selectByExample(BlogLabelMapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bloglabelmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    BlogLabelMap selectByPrimaryKey(Integer blogLabelId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bloglabelmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    int updateByExampleSelective(@Param("record") BlogLabelMap record, @Param("example") BlogLabelMapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bloglabelmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    int updateByExample(@Param("record") BlogLabelMap record, @Param("example") BlogLabelMapExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bloglabelmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    int updateByPrimaryKeySelective(BlogLabelMap record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bloglabelmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    int updateByPrimaryKey(BlogLabelMap record);

    List<BlogLabelMap> selectBlogLabelMapWithLabel(Integer BlogId);
}