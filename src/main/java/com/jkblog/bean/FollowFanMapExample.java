package com.jkblog.bean;

import java.util.ArrayList;
import java.util.List;

public class FollowFanMapExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table followfanmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table followfanmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table followfanmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followfanmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public FollowFanMapExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followfanmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followfanmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followfanmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followfanmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followfanmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followfanmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followfanmap
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
     * This method corresponds to the database table followfanmap
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
     * This method corresponds to the database table followfanmap
     *
     * @mbg.generated Mon Nov 02 23:27:58 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table followfanmap
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
     * This class corresponds to the database table followfanmap
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

        public Criteria andFollowFanIdIsNull() {
            addCriterion("followFanId is null");
            return (Criteria) this;
        }

        public Criteria andFollowFanIdIsNotNull() {
            addCriterion("followFanId is not null");
            return (Criteria) this;
        }

        public Criteria andFollowFanIdEqualTo(Integer value) {
            addCriterion("followFanId =", value, "followFanId");
            return (Criteria) this;
        }

        public Criteria andFollowFanIdNotEqualTo(Integer value) {
            addCriterion("followFanId <>", value, "followFanId");
            return (Criteria) this;
        }

        public Criteria andFollowFanIdGreaterThan(Integer value) {
            addCriterion("followFanId >", value, "followFanId");
            return (Criteria) this;
        }

        public Criteria andFollowFanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("followFanId >=", value, "followFanId");
            return (Criteria) this;
        }

        public Criteria andFollowFanIdLessThan(Integer value) {
            addCriterion("followFanId <", value, "followFanId");
            return (Criteria) this;
        }

        public Criteria andFollowFanIdLessThanOrEqualTo(Integer value) {
            addCriterion("followFanId <=", value, "followFanId");
            return (Criteria) this;
        }

        public Criteria andFollowFanIdIn(List<Integer> values) {
            addCriterion("followFanId in", values, "followFanId");
            return (Criteria) this;
        }

        public Criteria andFollowFanIdNotIn(List<Integer> values) {
            addCriterion("followFanId not in", values, "followFanId");
            return (Criteria) this;
        }

        public Criteria andFollowFanIdBetween(Integer value1, Integer value2) {
            addCriterion("followFanId between", value1, value2, "followFanId");
            return (Criteria) this;
        }

        public Criteria andFollowFanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("followFanId not between", value1, value2, "followFanId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdIsNull() {
            addCriterion("followUserId is null");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdIsNotNull() {
            addCriterion("followUserId is not null");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdEqualTo(Integer value) {
            addCriterion("followUserId =", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdNotEqualTo(Integer value) {
            addCriterion("followUserId <>", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdGreaterThan(Integer value) {
            addCriterion("followUserId >", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("followUserId >=", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdLessThan(Integer value) {
            addCriterion("followUserId <", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("followUserId <=", value, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdIn(List<Integer> values) {
            addCriterion("followUserId in", values, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdNotIn(List<Integer> values) {
            addCriterion("followUserId not in", values, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdBetween(Integer value1, Integer value2) {
            addCriterion("followUserId between", value1, value2, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFollowUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("followUserId not between", value1, value2, "followUserId");
            return (Criteria) this;
        }

        public Criteria andFanUserIdIsNull() {
            addCriterion("fanUserId is null");
            return (Criteria) this;
        }

        public Criteria andFanUserIdIsNotNull() {
            addCriterion("fanUserId is not null");
            return (Criteria) this;
        }

        public Criteria andFanUserIdEqualTo(Integer value) {
            addCriterion("fanUserId =", value, "fanUserId");
            return (Criteria) this;
        }

        public Criteria andFanUserIdNotEqualTo(Integer value) {
            addCriterion("fanUserId <>", value, "fanUserId");
            return (Criteria) this;
        }

        public Criteria andFanUserIdGreaterThan(Integer value) {
            addCriterion("fanUserId >", value, "fanUserId");
            return (Criteria) this;
        }

        public Criteria andFanUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fanUserId >=", value, "fanUserId");
            return (Criteria) this;
        }

        public Criteria andFanUserIdLessThan(Integer value) {
            addCriterion("fanUserId <", value, "fanUserId");
            return (Criteria) this;
        }

        public Criteria andFanUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("fanUserId <=", value, "fanUserId");
            return (Criteria) this;
        }

        public Criteria andFanUserIdIn(List<Integer> values) {
            addCriterion("fanUserId in", values, "fanUserId");
            return (Criteria) this;
        }

        public Criteria andFanUserIdNotIn(List<Integer> values) {
            addCriterion("fanUserId not in", values, "fanUserId");
            return (Criteria) this;
        }

        public Criteria andFanUserIdBetween(Integer value1, Integer value2) {
            addCriterion("fanUserId between", value1, value2, "fanUserId");
            return (Criteria) this;
        }

        public Criteria andFanUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fanUserId not between", value1, value2, "fanUserId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table followfanmap
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
     * This class corresponds to the database table followfanmap
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