package com.yousoft.cfapi.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PubcontentExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table API.PUBCONTENT
     *
     * @mbggenerated Sun Jun 28 23:28:44 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table API.PUBCONTENT
     *
     * @mbggenerated Sun Jun 28 23:28:44 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table API.PUBCONTENT
     *
     * @mbggenerated Sun Jun 28 23:28:44 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table API.PUBCONTENT
     *
     * @mbggenerated Sun Jun 28 23:28:44 CST 2015
     */
    public PubcontentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table API.PUBCONTENT
     *
     * @mbggenerated Sun Jun 28 23:28:44 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table API.PUBCONTENT
     *
     * @mbggenerated Sun Jun 28 23:28:44 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table API.PUBCONTENT
     *
     * @mbggenerated Sun Jun 28 23:28:44 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table API.PUBCONTENT
     *
     * @mbggenerated Sun Jun 28 23:28:44 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table API.PUBCONTENT
     *
     * @mbggenerated Sun Jun 28 23:28:44 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table API.PUBCONTENT
     *
     * @mbggenerated Sun Jun 28 23:28:44 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table API.PUBCONTENT
     *
     * @mbggenerated Sun Jun 28 23:28:44 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table API.PUBCONTENT
     *
     * @mbggenerated Sun Jun 28 23:28:44 CST 2015
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
     * This method corresponds to the database table API.PUBCONTENT
     *
     * @mbggenerated Sun Jun 28 23:28:44 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table API.PUBCONTENT
     *
     * @mbggenerated Sun Jun 28 23:28:44 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table API.PUBCONTENT
     *
     * @mbggenerated Sun Jun 28 23:28:44 CST 2015
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andCtidIsNull() {
            addCriterion("CTID is null");
            return (Criteria) this;
        }

        public Criteria andCtidIsNotNull() {
            addCriterion("CTID is not null");
            return (Criteria) this;
        }

        public Criteria andCtidEqualTo(BigDecimal value) {
            addCriterion("CTID =", value, "ctid");
            return (Criteria) this;
        }

        public Criteria andCtidNotEqualTo(BigDecimal value) {
            addCriterion("CTID <>", value, "ctid");
            return (Criteria) this;
        }

        public Criteria andCtidGreaterThan(BigDecimal value) {
            addCriterion("CTID >", value, "ctid");
            return (Criteria) this;
        }

        public Criteria andCtidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CTID >=", value, "ctid");
            return (Criteria) this;
        }

        public Criteria andCtidLessThan(BigDecimal value) {
            addCriterion("CTID <", value, "ctid");
            return (Criteria) this;
        }

        public Criteria andCtidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CTID <=", value, "ctid");
            return (Criteria) this;
        }

        public Criteria andCtidIn(List<BigDecimal> values) {
            addCriterion("CTID in", values, "ctid");
            return (Criteria) this;
        }

        public Criteria andCtidNotIn(List<BigDecimal> values) {
            addCriterion("CTID not in", values, "ctid");
            return (Criteria) this;
        }

        public Criteria andCtidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CTID between", value1, value2, "ctid");
            return (Criteria) this;
        }

        public Criteria andCtidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CTID not between", value1, value2, "ctid");
            return (Criteria) this;
        }

        public Criteria andTextIsNull() {
            addCriterion("TEXT is null");
            return (Criteria) this;
        }

        public Criteria andTextIsNotNull() {
            addCriterion("TEXT is not null");
            return (Criteria) this;
        }

        public Criteria andTextEqualTo(String value) {
            addCriterion("TEXT =", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotEqualTo(String value) {
            addCriterion("TEXT <>", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThan(String value) {
            addCriterion("TEXT >", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThanOrEqualTo(String value) {
            addCriterion("TEXT >=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThan(String value) {
            addCriterion("TEXT <", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThanOrEqualTo(String value) {
            addCriterion("TEXT <=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLike(String value) {
            addCriterion("TEXT like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotLike(String value) {
            addCriterion("TEXT not like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextIn(List<String> values) {
            addCriterion("TEXT in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotIn(List<String> values) {
            addCriterion("TEXT not in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextBetween(String value1, String value2) {
            addCriterion("TEXT between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotBetween(String value1, String value2) {
            addCriterion("TEXT not between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNull() {
            addCriterion("PHOTO is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIsNotNull() {
            addCriterion("PHOTO is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoEqualTo(String value) {
            addCriterion("PHOTO =", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotEqualTo(String value) {
            addCriterion("PHOTO <>", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThan(String value) {
            addCriterion("PHOTO >", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("PHOTO >=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThan(String value) {
            addCriterion("PHOTO <", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLessThanOrEqualTo(String value) {
            addCriterion("PHOTO <=", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoLike(String value) {
            addCriterion("PHOTO like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotLike(String value) {
            addCriterion("PHOTO not like", value, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoIn(List<String> values) {
            addCriterion("PHOTO in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotIn(List<String> values) {
            addCriterion("PHOTO not in", values, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoBetween(String value1, String value2) {
            addCriterion("PHOTO between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andPhotoNotBetween(String value1, String value2) {
            addCriterion("PHOTO not between", value1, value2, "photo");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andPubuidIsNull() {
            addCriterion("PUBUID is null");
            return (Criteria) this;
        }

        public Criteria andPubuidIsNotNull() {
            addCriterion("PUBUID is not null");
            return (Criteria) this;
        }

        public Criteria andPubuidEqualTo(String value) {
            addCriterion("PUBUID =", value, "pubuid");
            return (Criteria) this;
        }

        public Criteria andPubuidNotEqualTo(String value) {
            addCriterion("PUBUID <>", value, "pubuid");
            return (Criteria) this;
        }

        public Criteria andPubuidGreaterThan(String value) {
            addCriterion("PUBUID >", value, "pubuid");
            return (Criteria) this;
        }

        public Criteria andPubuidGreaterThanOrEqualTo(String value) {
            addCriterion("PUBUID >=", value, "pubuid");
            return (Criteria) this;
        }

        public Criteria andPubuidLessThan(String value) {
            addCriterion("PUBUID <", value, "pubuid");
            return (Criteria) this;
        }

        public Criteria andPubuidLessThanOrEqualTo(String value) {
            addCriterion("PUBUID <=", value, "pubuid");
            return (Criteria) this;
        }

        public Criteria andPubuidLike(String value) {
            addCriterion("PUBUID like", value, "pubuid");
            return (Criteria) this;
        }

        public Criteria andPubuidNotLike(String value) {
            addCriterion("PUBUID not like", value, "pubuid");
            return (Criteria) this;
        }

        public Criteria andPubuidIn(List<String> values) {
            addCriterion("PUBUID in", values, "pubuid");
            return (Criteria) this;
        }

        public Criteria andPubuidNotIn(List<String> values) {
            addCriterion("PUBUID not in", values, "pubuid");
            return (Criteria) this;
        }

        public Criteria andPubuidBetween(String value1, String value2) {
            addCriterion("PUBUID between", value1, value2, "pubuid");
            return (Criteria) this;
        }

        public Criteria andPubuidNotBetween(String value1, String value2) {
            addCriterion("PUBUID not between", value1, value2, "pubuid");
            return (Criteria) this;
        }

        public Criteria andPubtimeIsNull() {
            addCriterion("PUBTIME is null");
            return (Criteria) this;
        }

        public Criteria andPubtimeIsNotNull() {
            addCriterion("PUBTIME is not null");
            return (Criteria) this;
        }

        public Criteria andPubtimeEqualTo(Date value) {
            addCriterionForJDBCDate("PUBTIME =", value, "pubtime");
            return (Criteria) this;
        }

        public Criteria andPubtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("PUBTIME <>", value, "pubtime");
            return (Criteria) this;
        }

        public Criteria andPubtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("PUBTIME >", value, "pubtime");
            return (Criteria) this;
        }

        public Criteria andPubtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PUBTIME >=", value, "pubtime");
            return (Criteria) this;
        }

        public Criteria andPubtimeLessThan(Date value) {
            addCriterionForJDBCDate("PUBTIME <", value, "pubtime");
            return (Criteria) this;
        }

        public Criteria andPubtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("PUBTIME <=", value, "pubtime");
            return (Criteria) this;
        }

        public Criteria andPubtimeIn(List<Date> values) {
            addCriterionForJDBCDate("PUBTIME in", values, "pubtime");
            return (Criteria) this;
        }

        public Criteria andPubtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("PUBTIME not in", values, "pubtime");
            return (Criteria) this;
        }

        public Criteria andPubtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PUBTIME between", value1, value2, "pubtime");
            return (Criteria) this;
        }

        public Criteria andPubtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("PUBTIME not between", value1, value2, "pubtime");
            return (Criteria) this;
        }

        public Criteria andZancountIsNull() {
            addCriterion("ZANCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andZancountIsNotNull() {
            addCriterion("ZANCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andZancountEqualTo(BigDecimal value) {
            addCriterion("ZANCOUNT =", value, "zancount");
            return (Criteria) this;
        }

        public Criteria andZancountNotEqualTo(BigDecimal value) {
            addCriterion("ZANCOUNT <>", value, "zancount");
            return (Criteria) this;
        }

        public Criteria andZancountGreaterThan(BigDecimal value) {
            addCriterion("ZANCOUNT >", value, "zancount");
            return (Criteria) this;
        }

        public Criteria andZancountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ZANCOUNT >=", value, "zancount");
            return (Criteria) this;
        }

        public Criteria andZancountLessThan(BigDecimal value) {
            addCriterion("ZANCOUNT <", value, "zancount");
            return (Criteria) this;
        }

        public Criteria andZancountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ZANCOUNT <=", value, "zancount");
            return (Criteria) this;
        }

        public Criteria andZancountIn(List<BigDecimal> values) {
            addCriterion("ZANCOUNT in", values, "zancount");
            return (Criteria) this;
        }

        public Criteria andZancountNotIn(List<BigDecimal> values) {
            addCriterion("ZANCOUNT not in", values, "zancount");
            return (Criteria) this;
        }

        public Criteria andZancountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZANCOUNT between", value1, value2, "zancount");
            return (Criteria) this;
        }

        public Criteria andZancountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZANCOUNT not between", value1, value2, "zancount");
            return (Criteria) this;
        }

        public Criteria andPlcountIsNull() {
            addCriterion("PLCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPlcountIsNotNull() {
            addCriterion("PLCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPlcountEqualTo(BigDecimal value) {
            addCriterion("PLCOUNT =", value, "plcount");
            return (Criteria) this;
        }

        public Criteria andPlcountNotEqualTo(BigDecimal value) {
            addCriterion("PLCOUNT <>", value, "plcount");
            return (Criteria) this;
        }

        public Criteria andPlcountGreaterThan(BigDecimal value) {
            addCriterion("PLCOUNT >", value, "plcount");
            return (Criteria) this;
        }

        public Criteria andPlcountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PLCOUNT >=", value, "plcount");
            return (Criteria) this;
        }

        public Criteria andPlcountLessThan(BigDecimal value) {
            addCriterion("PLCOUNT <", value, "plcount");
            return (Criteria) this;
        }

        public Criteria andPlcountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PLCOUNT <=", value, "plcount");
            return (Criteria) this;
        }

        public Criteria andPlcountIn(List<BigDecimal> values) {
            addCriterion("PLCOUNT in", values, "plcount");
            return (Criteria) this;
        }

        public Criteria andPlcountNotIn(List<BigDecimal> values) {
            addCriterion("PLCOUNT not in", values, "plcount");
            return (Criteria) this;
        }

        public Criteria andPlcountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PLCOUNT between", value1, value2, "plcount");
            return (Criteria) this;
        }

        public Criteria andPlcountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PLCOUNT not between", value1, value2, "plcount");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table API.PUBCONTENT
     *
     * @mbggenerated do_not_delete_during_merge Sun Jun 28 23:28:44 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table API.PUBCONTENT
     *
     * @mbggenerated Sun Jun 28 23:28:44 CST 2015
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