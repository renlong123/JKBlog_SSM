package com.jkblog.bean;

public class BlogLabelMap {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bloglabelmap.blogLabelId
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    private Integer blogLabelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bloglabelmap.blogId
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    private Integer blogId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bloglabelmap.labelId
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    private Integer labelId;

    private BlogLabel blogLabel;

    public BlogLabel getBlogLabel() {
        return blogLabel;
    }

    public void setBlogLabel(BlogLabel blogLabel) {
        this.blogLabel = blogLabel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bloglabelmap.blogLabelId
     *
     * @return the value of bloglabelmap.blogLabelId
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public Integer getBlogLabelId() {
        return blogLabelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bloglabelmap.blogLabelId
     *
     * @param blogLabelId the value for bloglabelmap.blogLabelId
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public void setBlogLabelId(Integer blogLabelId) {
        this.blogLabelId = blogLabelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bloglabelmap.blogId
     *
     * @return the value of bloglabelmap.blogId
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public Integer getBlogId() {
        return blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bloglabelmap.blogId
     *
     * @param blogId the value for bloglabelmap.blogId
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bloglabelmap.labelId
     *
     * @return the value of bloglabelmap.labelId
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public Integer getLabelId() {
        return labelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bloglabelmap.labelId
     *
     * @param labelId the value for bloglabelmap.labelId
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }
}