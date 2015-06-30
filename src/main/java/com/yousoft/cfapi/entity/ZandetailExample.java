package com.yousoft.cfapi.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ZandetailExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table API.ZANDETAIL
	 * @mbggenerated  Tue Jun 30 11:49:46 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table API.ZANDETAIL
	 * @mbggenerated  Tue Jun 30 11:49:46 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table API.ZANDETAIL
	 * @mbggenerated  Tue Jun 30 11:49:46 CST 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table API.ZANDETAIL
	 * @mbggenerated  Tue Jun 30 11:49:46 CST 2015
	 */
	public ZandetailExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table API.ZANDETAIL
	 * @mbggenerated  Tue Jun 30 11:49:46 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table API.ZANDETAIL
	 * @mbggenerated  Tue Jun 30 11:49:46 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table API.ZANDETAIL
	 * @mbggenerated  Tue Jun 30 11:49:46 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table API.ZANDETAIL
	 * @mbggenerated  Tue Jun 30 11:49:46 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table API.ZANDETAIL
	 * @mbggenerated  Tue Jun 30 11:49:46 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table API.ZANDETAIL
	 * @mbggenerated  Tue Jun 30 11:49:46 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table API.ZANDETAIL
	 * @mbggenerated  Tue Jun 30 11:49:46 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table API.ZANDETAIL
	 * @mbggenerated  Tue Jun 30 11:49:46 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table API.ZANDETAIL
	 * @mbggenerated  Tue Jun 30 11:49:46 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table API.ZANDETAIL
	 * @mbggenerated  Tue Jun 30 11:49:46 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table API.ZANDETAIL
	 * @mbggenerated  Tue Jun 30 11:49:46 CST 2015
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andTextidIsNull() {
			addCriterion("TEXTID is null");
			return (Criteria) this;
		}

		public Criteria andTextidIsNotNull() {
			addCriterion("TEXTID is not null");
			return (Criteria) this;
		}

		public Criteria andTextidEqualTo(BigDecimal value) {
			addCriterion("TEXTID =", value, "textid");
			return (Criteria) this;
		}

		public Criteria andTextidNotEqualTo(BigDecimal value) {
			addCriterion("TEXTID <>", value, "textid");
			return (Criteria) this;
		}

		public Criteria andTextidGreaterThan(BigDecimal value) {
			addCriterion("TEXTID >", value, "textid");
			return (Criteria) this;
		}

		public Criteria andTextidGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TEXTID >=", value, "textid");
			return (Criteria) this;
		}

		public Criteria andTextidLessThan(BigDecimal value) {
			addCriterion("TEXTID <", value, "textid");
			return (Criteria) this;
		}

		public Criteria andTextidLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TEXTID <=", value, "textid");
			return (Criteria) this;
		}

		public Criteria andTextidIn(List<BigDecimal> values) {
			addCriterion("TEXTID in", values, "textid");
			return (Criteria) this;
		}

		public Criteria andTextidNotIn(List<BigDecimal> values) {
			addCriterion("TEXTID not in", values, "textid");
			return (Criteria) this;
		}

		public Criteria andTextidBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TEXTID between", value1, value2, "textid");
			return (Criteria) this;
		}

		public Criteria andTextidNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("TEXTID not between", value1, value2, "textid");
			return (Criteria) this;
		}

		public Criteria andUsernameIsNull() {
			addCriterion("USERNAME is null");
			return (Criteria) this;
		}

		public Criteria andUsernameIsNotNull() {
			addCriterion("USERNAME is not null");
			return (Criteria) this;
		}

		public Criteria andUsernameEqualTo(String value) {
			addCriterion("USERNAME =", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotEqualTo(String value) {
			addCriterion("USERNAME <>", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThan(String value) {
			addCriterion("USERNAME >", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThanOrEqualTo(String value) {
			addCriterion("USERNAME >=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThan(String value) {
			addCriterion("USERNAME <", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThanOrEqualTo(String value) {
			addCriterion("USERNAME <=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLike(String value) {
			addCriterion("USERNAME like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotLike(String value) {
			addCriterion("USERNAME not like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameIn(List<String> values) {
			addCriterion("USERNAME in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotIn(List<String> values) {
			addCriterion("USERNAME not in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameBetween(String value1, String value2) {
			addCriterion("USERNAME between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotBetween(String value1, String value2) {
			addCriterion("USERNAME not between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andUseridIsNull() {
			addCriterion("USERID is null");
			return (Criteria) this;
		}

		public Criteria andUseridIsNotNull() {
			addCriterion("USERID is not null");
			return (Criteria) this;
		}

		public Criteria andUseridEqualTo(String value) {
			addCriterion("USERID =", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotEqualTo(String value) {
			addCriterion("USERID <>", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridGreaterThan(String value) {
			addCriterion("USERID >", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridGreaterThanOrEqualTo(String value) {
			addCriterion("USERID >=", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLessThan(String value) {
			addCriterion("USERID <", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLessThanOrEqualTo(String value) {
			addCriterion("USERID <=", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridLike(String value) {
			addCriterion("USERID like", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotLike(String value) {
			addCriterion("USERID not like", value, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridIn(List<String> values) {
			addCriterion("USERID in", values, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotIn(List<String> values) {
			addCriterion("USERID not in", values, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridBetween(String value1, String value2) {
			addCriterion("USERID between", value1, value2, "userid");
			return (Criteria) this;
		}

		public Criteria andUseridNotBetween(String value1, String value2) {
			addCriterion("USERID not between", value1, value2, "userid");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table API.ZANDETAIL
	 * @mbggenerated  Tue Jun 30 11:49:46 CST 2015
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table API.ZANDETAIL
     *
     * @mbggenerated do_not_delete_during_merge Tue Jun 30 11:47:03 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}