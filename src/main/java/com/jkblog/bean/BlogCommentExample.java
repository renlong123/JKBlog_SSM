package com.jkblog.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogCommentExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table blogcomment
     *
     * @mbg.generated Thu Nov 05 17:39:29 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table blogcomment
     *
     * @mbg.generated Thu Nov 05 17:39:29 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table blogcomment
     *
     * @mbg.generated Thu Nov 05 17:39:29 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blogcomment
     *
     * @mbg.generated Thu Nov 05 17:39:29 CST 2020
     */
    public BlogCommentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blogcomment
     *
     * @mbg.generated Thu Nov 05 17:39:29 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blogcomment
     *
     * @mbg.generated Thu Nov 05 17:39:29 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blogcomment
     *
     * @mbg.generated Thu Nov 05 17:39:29 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blogcomment
     *
     * @mbg.generated Thu Nov 05 17:39:29 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blogcomment
     *
     * @mbg.generated Thu Nov 05 17:39:29 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blogcomment
     *
     * @mbg.generated Thu Nov 05 17:39:29 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blogcomment
     *
     * @mbg.generated Thu Nov 05 17:39:29 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blogcomment
     *
     * @mbg.generated Thu Nov 05 17:39:29 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blogcomment
     *
     * @mbg.generated Thu Nov 05 17:39:29 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blogcomment
     *
     * @mbg.generated Thu Nov 05 17:39:29 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table blogcomment
     *
     * @mbg.generated Thu Nov 05 17:39:29 CST 2020
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBlogCommentIdIsNull() {
            addCriterion("blogCommentId is null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdIsNotNull() {
            addCriterion("blogCommentId is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdEqualTo(Integer value) {
            addCriterion("blogCommentId =", value, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdNotEqualTo(Integer value) {
            addCriterion("blogCommentId <>", value, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdGreaterThan(Integer value) {
            addCriterion("blogCommentId >", value, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blogCommentId >=", value, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdLessThan(Integer value) {
            addCriterion("blogCommentId <", value, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("blogCommentId <=", value, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdIn(List<Integer> values) {
            addCriterion("blogCommentId in", values, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdNotIn(List<Integer> values) {
            addCriterion("blogCommentId not in", values, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("blogCommentId between", value1, value2, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blogCommentId not between", value1, value2, "blogCommentId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentContentsIsNull() {
            addCriterion("blogCommentContents is null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentContentsIsNotNull() {
            addCriterion("blogCommentContents is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentContentsEqualTo(String value) {
            addCriterion("blogCommentContents =", value, "blogCommentContents");
            return (Criteria) this;
        }

        public Criteria andBlogCommentContentsNotEqualTo(String value) {
            addCriterion("blogCommentContents <>", value, "blogCommentContents");
            return (Criteria) this;
        }

        public Criteria andBlogCommentContentsGreaterThan(String value) {
            addCriterion("blogCommentContents >", value, "blogCommentContents");
            return (Criteria) this;
        }

        public Criteria andBlogCommentContentsGreaterThanOrEqualTo(String value) {
            addCriterion("blogCommentContents >=", value, "blogCommentContents");
            return (Criteria) this;
        }

        public Criteria andBlogCommentContentsLessThan(String value) {
            addCriterion("blogCommentContents <", value, "blogCommentContents");
            return (Criteria) this;
        }

        public Criteria andBlogCommentContentsLessThanOrEqualTo(String value) {
            addCriterion("blogCommentContents <=", value, "blogCommentContents");
            return (Criteria) this;
        }

        public Criteria andBlogCommentContentsLike(String value) {
            addCriterion("blogCommentContents like", value, "blogCommentContents");
            return (Criteria) this;
        }

        public Criteria andBlogCommentContentsNotLike(String value) {
            addCriterion("blogCommentContents not like", value, "blogCommentContents");
            return (Criteria) this;
        }

        public Criteria andBlogCommentContentsIn(List<String> values) {
            addCriterion("blogCommentContents in", values, "blogCommentContents");
            return (Criteria) this;
        }

        public Criteria andBlogCommentContentsNotIn(List<String> values) {
            addCriterion("blogCommentContents not in", values, "blogCommentContents");
            return (Criteria) this;
        }

        public Criteria andBlogCommentContentsBetween(String value1, String value2) {
            addCriterion("blogCommentContents between", value1, value2, "blogCommentContents");
            return (Criteria) this;
        }

        public Criteria andBlogCommentContentsNotBetween(String value1, String value2) {
            addCriterion("blogCommentContents not between", value1, value2, "blogCommentContents");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimeIsNull() {
            addCriterion("blogCommentTime is null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimeIsNotNull() {
            addCriterion("blogCommentTime is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimeEqualTo(Date value) {
            addCriterion("blogCommentTime =", value, "blogCommentTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimeNotEqualTo(Date value) {
            addCriterion("blogCommentTime <>", value, "blogCommentTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimeGreaterThan(Date value) {
            addCriterion("blogCommentTime >", value, "blogCommentTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("blogCommentTime >=", value, "blogCommentTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimeLessThan(Date value) {
            addCriterion("blogCommentTime <", value, "blogCommentTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimeLessThanOrEqualTo(Date value) {
            addCriterion("blogCommentTime <=", value, "blogCommentTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimeIn(List<Date> values) {
            addCriterion("blogCommentTime in", values, "blogCommentTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimeNotIn(List<Date> values) {
            addCriterion("blogCommentTime not in", values, "blogCommentTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimeBetween(Date value1, Date value2) {
            addCriterion("blogCommentTime between", value1, value2, "blogCommentTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimeNotBetween(Date value1, Date value2) {
            addCriterion("blogCommentTime not between", value1, value2, "blogCommentTime");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserIdIsNull() {
            addCriterion("blogCommentUserId is null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserIdIsNotNull() {
            addCriterion("blogCommentUserId is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserIdEqualTo(Integer value) {
            addCriterion("blogCommentUserId =", value, "blogCommentUserId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserIdNotEqualTo(Integer value) {
            addCriterion("blogCommentUserId <>", value, "blogCommentUserId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserIdGreaterThan(Integer value) {
            addCriterion("blogCommentUserId >", value, "blogCommentUserId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blogCommentUserId >=", value, "blogCommentUserId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserIdLessThan(Integer value) {
            addCriterion("blogCommentUserId <", value, "blogCommentUserId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("blogCommentUserId <=", value, "blogCommentUserId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserIdIn(List<Integer> values) {
            addCriterion("blogCommentUserId in", values, "blogCommentUserId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserIdNotIn(List<Integer> values) {
            addCriterion("blogCommentUserId not in", values, "blogCommentUserId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserIdBetween(Integer value1, Integer value2) {
            addCriterion("blogCommentUserId between", value1, value2, "blogCommentUserId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blogCommentUserId not between", value1, value2, "blogCommentUserId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogIdIsNull() {
            addCriterion("blogCommentBlogId is null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogIdIsNotNull() {
            addCriterion("blogCommentBlogId is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogIdEqualTo(Integer value) {
            addCriterion("blogCommentBlogId =", value, "blogCommentBlogId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogIdNotEqualTo(Integer value) {
            addCriterion("blogCommentBlogId <>", value, "blogCommentBlogId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogIdGreaterThan(Integer value) {
            addCriterion("blogCommentBlogId >", value, "blogCommentBlogId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blogCommentBlogId >=", value, "blogCommentBlogId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogIdLessThan(Integer value) {
            addCriterion("blogCommentBlogId <", value, "blogCommentBlogId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogIdLessThanOrEqualTo(Integer value) {
            addCriterion("blogCommentBlogId <=", value, "blogCommentBlogId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogIdIn(List<Integer> values) {
            addCriterion("blogCommentBlogId in", values, "blogCommentBlogId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogIdNotIn(List<Integer> values) {
            addCriterion("blogCommentBlogId not in", values, "blogCommentBlogId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogIdBetween(Integer value1, Integer value2) {
            addCriterion("blogCommentBlogId between", value1, value2, "blogCommentBlogId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blogCommentBlogId not between", value1, value2, "blogCommentBlogId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogSonIdIsNull() {
            addCriterion("blogCommentBlogSonId is null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogSonIdIsNotNull() {
            addCriterion("blogCommentBlogSonId is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogSonIdEqualTo(Integer value) {
            addCriterion("blogCommentBlogSonId =", value, "blogCommentBlogSonId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogSonIdNotEqualTo(Integer value) {
            addCriterion("blogCommentBlogSonId <>", value, "blogCommentBlogSonId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogSonIdGreaterThan(Integer value) {
            addCriterion("blogCommentBlogSonId >", value, "blogCommentBlogSonId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogSonIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blogCommentBlogSonId >=", value, "blogCommentBlogSonId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogSonIdLessThan(Integer value) {
            addCriterion("blogCommentBlogSonId <", value, "blogCommentBlogSonId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogSonIdLessThanOrEqualTo(Integer value) {
            addCriterion("blogCommentBlogSonId <=", value, "blogCommentBlogSonId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogSonIdIn(List<Integer> values) {
            addCriterion("blogCommentBlogSonId in", values, "blogCommentBlogSonId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogSonIdNotIn(List<Integer> values) {
            addCriterion("blogCommentBlogSonId not in", values, "blogCommentBlogSonId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogSonIdBetween(Integer value1, Integer value2) {
            addCriterion("blogCommentBlogSonId between", value1, value2, "blogCommentBlogSonId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentBlogSonIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blogCommentBlogSonId not between", value1, value2, "blogCommentBlogSonId");
            return (Criteria) this;
        }

        public Criteria andBlogCommentFatherIsNull() {
            addCriterion("blogCommentFather is null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentFatherIsNotNull() {
            addCriterion("blogCommentFather is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentFatherEqualTo(Integer value) {
            addCriterion("blogCommentFather =", value, "blogCommentFather");
            return (Criteria) this;
        }

        public Criteria andBlogCommentFatherNotEqualTo(Integer value) {
            addCriterion("blogCommentFather <>", value, "blogCommentFather");
            return (Criteria) this;
        }

        public Criteria andBlogCommentFatherGreaterThan(Integer value) {
            addCriterion("blogCommentFather >", value, "blogCommentFather");
            return (Criteria) this;
        }

        public Criteria andBlogCommentFatherGreaterThanOrEqualTo(Integer value) {
            addCriterion("blogCommentFather >=", value, "blogCommentFather");
            return (Criteria) this;
        }

        public Criteria andBlogCommentFatherLessThan(Integer value) {
            addCriterion("blogCommentFather <", value, "blogCommentFather");
            return (Criteria) this;
        }

        public Criteria andBlogCommentFatherLessThanOrEqualTo(Integer value) {
            addCriterion("blogCommentFather <=", value, "blogCommentFather");
            return (Criteria) this;
        }

        public Criteria andBlogCommentFatherIn(List<Integer> values) {
            addCriterion("blogCommentFather in", values, "blogCommentFather");
            return (Criteria) this;
        }

        public Criteria andBlogCommentFatherNotIn(List<Integer> values) {
            addCriterion("blogCommentFather not in", values, "blogCommentFather");
            return (Criteria) this;
        }

        public Criteria andBlogCommentFatherBetween(Integer value1, Integer value2) {
            addCriterion("blogCommentFather between", value1, value2, "blogCommentFather");
            return (Criteria) this;
        }

        public Criteria andBlogCommentFatherNotBetween(Integer value1, Integer value2) {
            addCriterion("blogCommentFather not between", value1, value2, "blogCommentFather");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserNameIsNull() {
            addCriterion("blogCommentUserName is null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserNameIsNotNull() {
            addCriterion("blogCommentUserName is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserNameEqualTo(String value) {
            addCriterion("blogCommentUserName =", value, "blogCommentUserName");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserNameNotEqualTo(String value) {
            addCriterion("blogCommentUserName <>", value, "blogCommentUserName");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserNameGreaterThan(String value) {
            addCriterion("blogCommentUserName >", value, "blogCommentUserName");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("blogCommentUserName >=", value, "blogCommentUserName");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserNameLessThan(String value) {
            addCriterion("blogCommentUserName <", value, "blogCommentUserName");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserNameLessThanOrEqualTo(String value) {
            addCriterion("blogCommentUserName <=", value, "blogCommentUserName");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserNameLike(String value) {
            addCriterion("blogCommentUserName like", value, "blogCommentUserName");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserNameNotLike(String value) {
            addCriterion("blogCommentUserName not like", value, "blogCommentUserName");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserNameIn(List<String> values) {
            addCriterion("blogCommentUserName in", values, "blogCommentUserName");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserNameNotIn(List<String> values) {
            addCriterion("blogCommentUserName not in", values, "blogCommentUserName");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserNameBetween(String value1, String value2) {
            addCriterion("blogCommentUserName between", value1, value2, "blogCommentUserName");
            return (Criteria) this;
        }

        public Criteria andBlogCommentUserNameNotBetween(String value1, String value2) {
            addCriterion("blogCommentUserName not between", value1, value2, "blogCommentUserName");
            return (Criteria) this;
        }

        public Criteria andBlogCommentSonCountIsNull() {
            addCriterion("blogCommentSonCount is null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentSonCountIsNotNull() {
            addCriterion("blogCommentSonCount is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentSonCountEqualTo(Integer value) {
            addCriterion("blogCommentSonCount =", value, "blogCommentSonCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentSonCountNotEqualTo(Integer value) {
            addCriterion("blogCommentSonCount <>", value, "blogCommentSonCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentSonCountGreaterThan(Integer value) {
            addCriterion("blogCommentSonCount >", value, "blogCommentSonCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentSonCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("blogCommentSonCount >=", value, "blogCommentSonCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentSonCountLessThan(Integer value) {
            addCriterion("blogCommentSonCount <", value, "blogCommentSonCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentSonCountLessThanOrEqualTo(Integer value) {
            addCriterion("blogCommentSonCount <=", value, "blogCommentSonCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentSonCountIn(List<Integer> values) {
            addCriterion("blogCommentSonCount in", values, "blogCommentSonCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentSonCountNotIn(List<Integer> values) {
            addCriterion("blogCommentSonCount not in", values, "blogCommentSonCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentSonCountBetween(Integer value1, Integer value2) {
            addCriterion("blogCommentSonCount between", value1, value2, "blogCommentSonCount");
            return (Criteria) this;
        }

        public Criteria andBlogCommentSonCountNotBetween(Integer value1, Integer value2) {
            addCriterion("blogCommentSonCount not between", value1, value2, "blogCommentSonCount");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table blogcomment
     *
     * @mbg.generated do_not_delete_during_merge Thu Nov 05 17:39:29 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table blogcomment
     *
     * @mbg.generated Thu Nov 05 17:39:29 CST 2020
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}