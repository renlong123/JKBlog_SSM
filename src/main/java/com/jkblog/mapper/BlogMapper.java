package com.jkblog.mapper;

import com.jkblog.bean.Blog;
import com.jkblog.bean.BlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    long countByExample(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    int deleteByExample(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    int deleteByPrimaryKey(Integer blogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    int insert(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    int insertSelective(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    List<Blog> selectByExampleWithBLOBs(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    List<Blog> selectByExample(BlogExample example);

    /*查询最热博客
    * */
    List<Blog> selectHotBlogs(Integer number);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    Blog selectByPrimaryKey(Integer blogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") Blog record, @Param("example") BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    int updateByPrimaryKeySelective(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    int updateByPrimaryKey(Blog record);
}