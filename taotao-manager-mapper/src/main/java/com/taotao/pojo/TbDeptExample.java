package com.taotao.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbDeptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbDeptExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Long value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Long value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Long value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Long value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Long value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Long> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Long> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Long value1, Long value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Long value1, Long value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptAddrIsNull() {
            addCriterion("dept_addr is null");
            return (Criteria) this;
        }

        public Criteria andDeptAddrIsNotNull() {
            addCriterion("dept_addr is not null");
            return (Criteria) this;
        }

        public Criteria andDeptAddrEqualTo(String value) {
            addCriterion("dept_addr =", value, "deptAddr");
            return (Criteria) this;
        }

        public Criteria andDeptAddrNotEqualTo(String value) {
            addCriterion("dept_addr <>", value, "deptAddr");
            return (Criteria) this;
        }

        public Criteria andDeptAddrGreaterThan(String value) {
            addCriterion("dept_addr >", value, "deptAddr");
            return (Criteria) this;
        }

        public Criteria andDeptAddrGreaterThanOrEqualTo(String value) {
            addCriterion("dept_addr >=", value, "deptAddr");
            return (Criteria) this;
        }

        public Criteria andDeptAddrLessThan(String value) {
            addCriterion("dept_addr <", value, "deptAddr");
            return (Criteria) this;
        }

        public Criteria andDeptAddrLessThanOrEqualTo(String value) {
            addCriterion("dept_addr <=", value, "deptAddr");
            return (Criteria) this;
        }

        public Criteria andDeptAddrLike(String value) {
            addCriterion("dept_addr like", value, "deptAddr");
            return (Criteria) this;
        }

        public Criteria andDeptAddrNotLike(String value) {
            addCriterion("dept_addr not like", value, "deptAddr");
            return (Criteria) this;
        }

        public Criteria andDeptAddrIn(List<String> values) {
            addCriterion("dept_addr in", values, "deptAddr");
            return (Criteria) this;
        }

        public Criteria andDeptAddrNotIn(List<String> values) {
            addCriterion("dept_addr not in", values, "deptAddr");
            return (Criteria) this;
        }

        public Criteria andDeptAddrBetween(String value1, String value2) {
            addCriterion("dept_addr between", value1, value2, "deptAddr");
            return (Criteria) this;
        }

        public Criteria andDeptAddrNotBetween(String value1, String value2) {
            addCriterion("dept_addr not between", value1, value2, "deptAddr");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNull() {
            addCriterion("dept_name is null");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNotNull() {
            addCriterion("dept_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeptNameEqualTo(String value) {
            addCriterion("dept_name =", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotEqualTo(String value) {
            addCriterion("dept_name <>", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThan(String value) {
            addCriterion("dept_name >", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("dept_name >=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThan(String value) {
            addCriterion("dept_name <", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThanOrEqualTo(String value) {
            addCriterion("dept_name <=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLike(String value) {
            addCriterion("dept_name like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotLike(String value) {
            addCriterion("dept_name not like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameIn(List<String> values) {
            addCriterion("dept_name in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotIn(List<String> values) {
            addCriterion("dept_name not in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameBetween(String value1, String value2) {
            addCriterion("dept_name between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotBetween(String value1, String value2) {
            addCriterion("dept_name not between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptmanagerIsNull() {
            addCriterion("deptmanager is null");
            return (Criteria) this;
        }

        public Criteria andDeptmanagerIsNotNull() {
            addCriterion("deptmanager is not null");
            return (Criteria) this;
        }

        public Criteria andDeptmanagerEqualTo(String value) {
            addCriterion("deptmanager =", value, "deptmanager");
            return (Criteria) this;
        }

        public Criteria andDeptmanagerNotEqualTo(String value) {
            addCriterion("deptmanager <>", value, "deptmanager");
            return (Criteria) this;
        }

        public Criteria andDeptmanagerGreaterThan(String value) {
            addCriterion("deptmanager >", value, "deptmanager");
            return (Criteria) this;
        }

        public Criteria andDeptmanagerGreaterThanOrEqualTo(String value) {
            addCriterion("deptmanager >=", value, "deptmanager");
            return (Criteria) this;
        }

        public Criteria andDeptmanagerLessThan(String value) {
            addCriterion("deptmanager <", value, "deptmanager");
            return (Criteria) this;
        }

        public Criteria andDeptmanagerLessThanOrEqualTo(String value) {
            addCriterion("deptmanager <=", value, "deptmanager");
            return (Criteria) this;
        }

        public Criteria andDeptmanagerLike(String value) {
            addCriterion("deptmanager like", value, "deptmanager");
            return (Criteria) this;
        }

        public Criteria andDeptmanagerNotLike(String value) {
            addCriterion("deptmanager not like", value, "deptmanager");
            return (Criteria) this;
        }

        public Criteria andDeptmanagerIn(List<String> values) {
            addCriterion("deptmanager in", values, "deptmanager");
            return (Criteria) this;
        }

        public Criteria andDeptmanagerNotIn(List<String> values) {
            addCriterion("deptmanager not in", values, "deptmanager");
            return (Criteria) this;
        }

        public Criteria andDeptmanagerBetween(String value1, String value2) {
            addCriterion("deptmanager between", value1, value2, "deptmanager");
            return (Criteria) this;
        }

        public Criteria andDeptmanagerNotBetween(String value1, String value2) {
            addCriterion("deptmanager not between", value1, value2, "deptmanager");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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