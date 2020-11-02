package com.jkblog.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public BlogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
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
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
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

        public Criteria andBlogIdIsNull() {
            addCriterion("blogId is null");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNotNull() {
            addCriterion("blogId is not null");
            return (Criteria) this;
        }

        public Criteria andBlogIdEqualTo(Integer value) {
            addCriterion("blogId =", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotEqualTo(Integer value) {
            addCriterion("blogId <>", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThan(Integer value) {
            addCriterion("blogId >", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blogId >=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThan(Integer value) {
            addCriterion("blogId <", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThanOrEqualTo(Integer value) {
            addCriterion("blogId <=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdIn(List<Integer> values) {
            addCriterion("blogId in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotIn(List<Integer> values) {
            addCriterion("blogId not in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdBetween(Integer value1, Integer value2) {
            addCriterion("blogId between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blogId not between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNull() {
            addCriterion("blogTitle is null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNotNull() {
            addCriterion("blogTitle is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleEqualTo(String value) {
            addCriterion("blogTitle =", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotEqualTo(String value) {
            addCriterion("blogTitle <>", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThan(String value) {
            addCriterion("blogTitle >", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThanOrEqualTo(String value) {
            addCriterion("blogTitle >=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThan(String value) {
            addCriterion("blogTitle <", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThanOrEqualTo(String value) {
            addCriterion("blogTitle <=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLike(String value) {
            addCriterion("blogTitle like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotLike(String value) {
            addCriterion("blogTitle not like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIn(List<String> values) {
            addCriterion("blogTitle in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotIn(List<String> values) {
            addCriterion("blogTitle not in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleBetween(String value1, String value2) {
            addCriterion("blogTitle between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotBetween(String value1, String value2) {
            addCriterion("blogTitle not between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogReadTimesIsNull() {
            addCriterion("blogReadTimes is null");
            return (Criteria) this;
        }

        public Criteria andBlogReadTimesIsNotNull() {
            addCriterion("blogReadTimes is not null");
            return (Criteria) this;
        }

        public Criteria andBlogReadTimesEqualTo(Integer value) {
            addCriterion("blogReadTimes =", value, "blogReadTimes");
            return (Criteria) this;
        }

        public Criteria andBlogReadTimesNotEqualTo(Integer value) {
            addCriterion("blogReadTimes <>", value, "blogReadTimes");
            return (Criteria) this;
        }

        public Criteria andBlogReadTimesGreaterThan(Integer value) {
            addCriterion("blogReadTimes >", value, "blogReadTimes");
            return (Criteria) this;
        }

        public Criteria andBlogReadTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("blogReadTimes >=", value, "blogReadTimes");
            return (Criteria) this;
        }

        public Criteria andBlogReadTimesLessThan(Integer value) {
            addCriterion("blogReadTimes <", value, "blogReadTimes");
            return (Criteria) this;
        }

        public Criteria andBlogReadTimesLessThanOrEqualTo(Integer value) {
            addCriterion("blogReadTimes <=", value, "blogReadTimes");
            return (Criteria) this;
        }

        public Criteria andBlogReadTimesIn(List<Integer> values) {
            addCriterion("blogReadTimes in", values, "blogReadTimes");
            return (Criteria) this;
        }

        public Criteria andBlogReadTimesNotIn(List<Integer> values) {
            addCriterion("blogReadTimes not in", values, "blogReadTimes");
            return (Criteria) this;
        }

        public Criteria andBlogReadTimesBetween(Integer value1, Integer value2) {
            addCriterion("blogReadTimes between", value1, value2, "blogReadTimes");
            return (Criteria) this;
        }

        public Criteria andBlogReadTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("blogReadTimes not between", value1, value2, "blogReadTimes");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimesIsNull() {
            addCriterion("blogCommentTimes is null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimesIsNotNull() {
            addCriterion("blogCommentTimes is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimesEqualTo(Integer value) {
            addCriterion("blogCommentTimes =", value, "blogCommentTimes");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimesNotEqualTo(Integer value) {
            addCriterion("blogCommentTimes <>", value, "blogCommentTimes");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimesGreaterThan(Integer value) {
            addCriterion("blogCommentTimes >", value, "blogCommentTimes");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("blogCommentTimes >=", value, "blogCommentTimes");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimesLessThan(Integer value) {
            addCriterion("blogCommentTimes <", value, "blogCommentTimes");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimesLessThanOrEqualTo(Integer value) {
            addCriterion("blogCommentTimes <=", value, "blogCommentTimes");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimesIn(List<Integer> values) {
            addCriterion("blogCommentTimes in", values, "blogCommentTimes");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimesNotIn(List<Integer> values) {
            addCriterion("blogCommentTimes not in", values, "blogCommentTimes");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimesBetween(Integer value1, Integer value2) {
            addCriterion("blogCommentTimes between", value1, value2, "blogCommentTimes");
            return (Criteria) this;
        }

        public Criteria andBlogCommentTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("blogCommentTimes not between", value1, value2, "blogCommentTimes");
            return (Criteria) this;
        }

        public Criteria andBlogEditTimeIsNull() {
            addCriterion("blogEditTime is null");
            return (Criteria) this;
        }

        public Criteria andBlogEditTimeIsNotNull() {
            addCriterion("blogEditTime is not null");
            return (Criteria) this;
        }

        public Criteria andBlogEditTimeEqualTo(Date value) {
            addCriterion("blogEditTime =", value, "blogEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogEditTimeNotEqualTo(Date value) {
            addCriterion("blogEditTime <>", value, "blogEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogEditTimeGreaterThan(Date value) {
            addCriterion("blogEditTime >", value, "blogEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogEditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("blogEditTime >=", value, "blogEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogEditTimeLessThan(Date value) {
            addCriterion("blogEditTime <", value, "blogEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogEditTimeLessThanOrEqualTo(Date value) {
            addCriterion("blogEditTime <=", value, "blogEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogEditTimeIn(List<Date> values) {
            addCriterion("blogEditTime in", values, "blogEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogEditTimeNotIn(List<Date> values) {
            addCriterion("blogEditTime not in", values, "blogEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogEditTimeBetween(Date value1, Date value2) {
            addCriterion("blogEditTime between", value1, value2, "blogEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogEditTimeNotBetween(Date value1, Date value2) {
            addCriterion("blogEditTime not between", value1, value2, "blogEditTime");
            return (Criteria) this;
        }

        public Criteria andBlogUserIdIsNull() {
            addCriterion("blogUserId is null");
            return (Criteria) this;
        }

        public Criteria andBlogUserIdIsNotNull() {
            addCriterion("blogUserId is not null");
            return (Criteria) this;
        }

        public Criteria andBlogUserIdEqualTo(Integer value) {
            addCriterion("blogUserId =", value, "blogUserId");
            return (Criteria) this;
        }

        public Criteria andBlogUserIdNotEqualTo(Integer value) {
            addCriterion("blogUserId <>", value, "blogUserId");
            return (Criteria) this;
        }

        public Criteria andBlogUserIdGreaterThan(Integer value) {
            addCriterion("blogUserId >", value, "blogUserId");
            return (Criteria) this;
        }

        public Criteria andBlogUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blogUserId >=", value, "blogUserId");
            return (Criteria) this;
        }

        public Criteria andBlogUserIdLessThan(Integer value) {
            addCriterion("blogUserId <", value, "blogUserId");
            return (Criteria) this;
        }

        public Criteria andBlogUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("blogUserId <=", value, "blogUserId");
            return (Criteria) this;
        }

        public Criteria andBlogUserIdIn(List<Integer> values) {
            addCriterion("blogUserId in", values, "blogUserId");
            return (Criteria) this;
        }

        public Criteria andBlogUserIdNotIn(List<Integer> values) {
            addCriterion("blogUserId not in", values, "blogUserId");
            return (Criteria) this;
        }

        public Criteria andBlogUserIdBetween(Integer value1, Integer value2) {
            addCriterion("blogUserId between", value1, value2, "blogUserId");
            return (Criteria) this;
        }

        public Criteria andBlogUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blogUserId not between", value1, value2, "blogUserId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdIsNull() {
            addCriterion("blogCategoryId is null");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdIsNotNull() {
            addCriterion("blogCategoryId is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdEqualTo(Integer value) {
            addCriterion("blogCategoryId =", value, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdNotEqualTo(Integer value) {
            addCriterion("blogCategoryId <>", value, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdGreaterThan(Integer value) {
            addCriterion("blogCategoryId >", value, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blogCategoryId >=", value, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdLessThan(Integer value) {
            addCriterion("blogCategoryId <", value, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("blogCategoryId <=", value, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdIn(List<Integer> values) {
            addCriterion("blogCategoryId in", values, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdNotIn(List<Integer> values) {
            addCriterion("blogCategoryId not in", values, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("blogCategoryId between", value1, value2, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blogCategoryId not between", value1, value2, "blogCategoryId");
            return (Criteria) this;
        }

        public Criteria andBlogBriefContentIsNull() {
            addCriterion("blogBriefContent is null");
            return (Criteria) this;
        }

        public Criteria andBlogBriefContentIsNotNull() {
            addCriterion("blogBriefContent is not null");
            return (Criteria) this;
        }

        public Criteria andBlogBriefContentEqualTo(String value) {
            addCriterion("blogBriefContent =", value, "blogBriefContent");
            return (Criteria) this;
        }

        public Criteria andBlogBriefContentNotEqualTo(String value) {
            addCriterion("blogBriefContent <>", value, "blogBriefContent");
            return (Criteria) this;
        }

        public Criteria andBlogBriefContentGreaterThan(String value) {
            addCriterion("blogBriefContent >", value, "blogBriefContent");
            return (Criteria) this;
        }

        public Criteria andBlogBriefContentGreaterThanOrEqualTo(String value) {
            addCriterion("blogBriefContent >=", value, "blogBriefContent");
            return (Criteria) this;
        }

        public Criteria andBlogBriefContentLessThan(String value) {
            addCriterion("blogBriefContent <", value, "blogBriefContent");
            return (Criteria) this;
        }

        public Criteria andBlogBriefContentLessThanOrEqualTo(String value) {
            addCriterion("blogBriefContent <=", value, "blogBriefContent");
            return (Criteria) this;
        }

        public Criteria andBlogBriefContentLike(String value) {
            addCriterion("blogBriefContent like", value, "blogBriefContent");
            return (Criteria) this;
        }

        public Criteria andBlogBriefContentNotLike(String value) {
            addCriterion("blogBriefContent not like", value, "blogBriefContent");
            return (Criteria) this;
        }

        public Criteria andBlogBriefContentIn(List<String> values) {
            addCriterion("blogBriefContent in", values, "blogBriefContent");
            return (Criteria) this;
        }

        public Criteria andBlogBriefContentNotIn(List<String> values) {
            addCriterion("blogBriefContent not in", values, "blogBriefContent");
            return (Criteria) this;
        }

        public Criteria andBlogBriefContentBetween(String value1, String value2) {
            addCriterion("blogBriefContent between", value1, value2, "blogBriefContent");
            return (Criteria) this;
        }

        public Criteria andBlogBriefContentNotBetween(String value1, String value2) {
            addCriterion("blogBriefContent not between", value1, value2, "blogBriefContent");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table blog
     *
     * @mbg.generated do_not_delete_during_merge Mon Nov 02 23:27:58 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table blog
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
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