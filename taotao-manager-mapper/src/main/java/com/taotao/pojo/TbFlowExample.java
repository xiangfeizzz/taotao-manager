package com.taotao.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbFlowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbFlowExample() {
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

        public Criteria andFlowIdIsNull() {
            addCriterion("flow_id is null");
            return (Criteria) this;
        }

        public Criteria andFlowIdIsNotNull() {
            addCriterion("flow_id is not null");
            return (Criteria) this;
        }

        public Criteria andFlowIdEqualTo(Integer value) {
            addCriterion("flow_id =", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotEqualTo(Integer value) {
            addCriterion("flow_id <>", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdGreaterThan(Integer value) {
            addCriterion("flow_id >", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("flow_id >=", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdLessThan(Integer value) {
            addCriterion("flow_id <", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdLessThanOrEqualTo(Integer value) {
            addCriterion("flow_id <=", value, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdIn(List<Integer> values) {
            addCriterion("flow_id in", values, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotIn(List<Integer> values) {
            addCriterion("flow_id not in", values, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdBetween(Integer value1, Integer value2) {
            addCriterion("flow_id between", value1, value2, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowIdNotBetween(Integer value1, Integer value2) {
            addCriterion("flow_id not between", value1, value2, "flowId");
            return (Criteria) this;
        }

        public Criteria andFlowStatusIsNull() {
            addCriterion("flow_status is null");
            return (Criteria) this;
        }

        public Criteria andFlowStatusIsNotNull() {
            addCriterion("flow_status is not null");
            return (Criteria) this;
        }

        public Criteria andFlowStatusEqualTo(String value) {
            addCriterion("flow_status =", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusNotEqualTo(String value) {
            addCriterion("flow_status <>", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusGreaterThan(String value) {
            addCriterion("flow_status >", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusGreaterThanOrEqualTo(String value) {
            addCriterion("flow_status >=", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusLessThan(String value) {
            addCriterion("flow_status <", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusLessThanOrEqualTo(String value) {
            addCriterion("flow_status <=", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusLike(String value) {
            addCriterion("flow_status like", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusNotLike(String value) {
            addCriterion("flow_status not like", value, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusIn(List<String> values) {
            addCriterion("flow_status in", values, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusNotIn(List<String> values) {
            addCriterion("flow_status not in", values, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusBetween(String value1, String value2) {
            addCriterion("flow_status between", value1, value2, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowStatusNotBetween(String value1, String value2) {
            addCriterion("flow_status not between", value1, value2, "flowStatus");
            return (Criteria) this;
        }

        public Criteria andFlowTypeIsNull() {
            addCriterion("flow_type is null");
            return (Criteria) this;
        }

        public Criteria andFlowTypeIsNotNull() {
            addCriterion("flow_type is not null");
            return (Criteria) this;
        }

        public Criteria andFlowTypeEqualTo(String value) {
            addCriterion("flow_type =", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotEqualTo(String value) {
            addCriterion("flow_type <>", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeGreaterThan(String value) {
            addCriterion("flow_type >", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeGreaterThanOrEqualTo(String value) {
            addCriterion("flow_type >=", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeLessThan(String value) {
            addCriterion("flow_type <", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeLessThanOrEqualTo(String value) {
            addCriterion("flow_type <=", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeLike(String value) {
            addCriterion("flow_type like", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotLike(String value) {
            addCriterion("flow_type not like", value, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeIn(List<String> values) {
            addCriterion("flow_type in", values, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotIn(List<String> values) {
            addCriterion("flow_type not in", values, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeBetween(String value1, String value2) {
            addCriterion("flow_type between", value1, value2, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowTypeNotBetween(String value1, String value2) {
            addCriterion("flow_type not between", value1, value2, "flowType");
            return (Criteria) this;
        }

        public Criteria andFlowNameIsNull() {
            addCriterion("flow_name is null");
            return (Criteria) this;
        }

        public Criteria andFlowNameIsNotNull() {
            addCriterion("flow_name is not null");
            return (Criteria) this;
        }

        public Criteria andFlowNameEqualTo(String value) {
            addCriterion("flow_name =", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameNotEqualTo(String value) {
            addCriterion("flow_name <>", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameGreaterThan(String value) {
            addCriterion("flow_name >", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameGreaterThanOrEqualTo(String value) {
            addCriterion("flow_name >=", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameLessThan(String value) {
            addCriterion("flow_name <", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameLessThanOrEqualTo(String value) {
            addCriterion("flow_name <=", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameLike(String value) {
            addCriterion("flow_name like", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameNotLike(String value) {
            addCriterion("flow_name not like", value, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameIn(List<String> values) {
            addCriterion("flow_name in", values, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameNotIn(List<String> values) {
            addCriterion("flow_name not in", values, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameBetween(String value1, String value2) {
            addCriterion("flow_name between", value1, value2, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowNameNotBetween(String value1, String value2) {
            addCriterion("flow_name not between", value1, value2, "flowName");
            return (Criteria) this;
        }

        public Criteria andFlowOrderIsNull() {
            addCriterion("flow_order is null");
            return (Criteria) this;
        }

        public Criteria andFlowOrderIsNotNull() {
            addCriterion("flow_order is not null");
            return (Criteria) this;
        }

        public Criteria andFlowOrderEqualTo(String value) {
            addCriterion("flow_order =", value, "flowOrder");
            return (Criteria) this;
        }

        public Criteria andFlowOrderNotEqualTo(String value) {
            addCriterion("flow_order <>", value, "flowOrder");
            return (Criteria) this;
        }

        public Criteria andFlowOrderGreaterThan(String value) {
            addCriterion("flow_order >", value, "flowOrder");
            return (Criteria) this;
        }

        public Criteria andFlowOrderGreaterThanOrEqualTo(String value) {
            addCriterion("flow_order >=", value, "flowOrder");
            return (Criteria) this;
        }

        public Criteria andFlowOrderLessThan(String value) {
            addCriterion("flow_order <", value, "flowOrder");
            return (Criteria) this;
        }

        public Criteria andFlowOrderLessThanOrEqualTo(String value) {
            addCriterion("flow_order <=", value, "flowOrder");
            return (Criteria) this;
        }

        public Criteria andFlowOrderLike(String value) {
            addCriterion("flow_order like", value, "flowOrder");
            return (Criteria) this;
        }

        public Criteria andFlowOrderNotLike(String value) {
            addCriterion("flow_order not like", value, "flowOrder");
            return (Criteria) this;
        }

        public Criteria andFlowOrderIn(List<String> values) {
            addCriterion("flow_order in", values, "flowOrder");
            return (Criteria) this;
        }

        public Criteria andFlowOrderNotIn(List<String> values) {
            addCriterion("flow_order not in", values, "flowOrder");
            return (Criteria) this;
        }

        public Criteria andFlowOrderBetween(String value1, String value2) {
            addCriterion("flow_order between", value1, value2, "flowOrder");
            return (Criteria) this;
        }

        public Criteria andFlowOrderNotBetween(String value1, String value2) {
            addCriterion("flow_order not between", value1, value2, "flowOrder");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeIsNull() {
            addCriterion("holiday_type is null");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeIsNotNull() {
            addCriterion("holiday_type is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeEqualTo(String value) {
            addCriterion("holiday_type =", value, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeNotEqualTo(String value) {
            addCriterion("holiday_type <>", value, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeGreaterThan(String value) {
            addCriterion("holiday_type >", value, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("holiday_type >=", value, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeLessThan(String value) {
            addCriterion("holiday_type <", value, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeLessThanOrEqualTo(String value) {
            addCriterion("holiday_type <=", value, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeLike(String value) {
            addCriterion("holiday_type like", value, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeNotLike(String value) {
            addCriterion("holiday_type not like", value, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeIn(List<String> values) {
            addCriterion("holiday_type in", values, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeNotIn(List<String> values) {
            addCriterion("holiday_type not in", values, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeBetween(String value1, String value2) {
            addCriterion("holiday_type between", value1, value2, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayTypeNotBetween(String value1, String value2) {
            addCriterion("holiday_type not between", value1, value2, "holidayType");
            return (Criteria) this;
        }

        public Criteria andHolidayStartTimeIsNull() {
            addCriterion("holiday_start_time is null");
            return (Criteria) this;
        }

        public Criteria andHolidayStartTimeIsNotNull() {
            addCriterion("holiday_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayStartTimeEqualTo(String value) {
            addCriterion("holiday_start_time =", value, "holidayStartTime");
            return (Criteria) this;
        }

        public Criteria andHolidayStartTimeNotEqualTo(String value) {
            addCriterion("holiday_start_time <>", value, "holidayStartTime");
            return (Criteria) this;
        }

        public Criteria andHolidayStartTimeGreaterThan(String value) {
            addCriterion("holiday_start_time >", value, "holidayStartTime");
            return (Criteria) this;
        }

        public Criteria andHolidayStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("holiday_start_time >=", value, "holidayStartTime");
            return (Criteria) this;
        }

        public Criteria andHolidayStartTimeLessThan(String value) {
            addCriterion("holiday_start_time <", value, "holidayStartTime");
            return (Criteria) this;
        }

        public Criteria andHolidayStartTimeLessThanOrEqualTo(String value) {
            addCriterion("holiday_start_time <=", value, "holidayStartTime");
            return (Criteria) this;
        }

        public Criteria andHolidayStartTimeLike(String value) {
            addCriterion("holiday_start_time like", value, "holidayStartTime");
            return (Criteria) this;
        }

        public Criteria andHolidayStartTimeNotLike(String value) {
            addCriterion("holiday_start_time not like", value, "holidayStartTime");
            return (Criteria) this;
        }

        public Criteria andHolidayStartTimeIn(List<String> values) {
            addCriterion("holiday_start_time in", values, "holidayStartTime");
            return (Criteria) this;
        }

        public Criteria andHolidayStartTimeNotIn(List<String> values) {
            addCriterion("holiday_start_time not in", values, "holidayStartTime");
            return (Criteria) this;
        }

        public Criteria andHolidayStartTimeBetween(String value1, String value2) {
            addCriterion("holiday_start_time between", value1, value2, "holidayStartTime");
            return (Criteria) this;
        }

        public Criteria andHolidayStartTimeNotBetween(String value1, String value2) {
            addCriterion("holiday_start_time not between", value1, value2, "holidayStartTime");
            return (Criteria) this;
        }

        public Criteria andHolidayEndTimeIsNull() {
            addCriterion("holiday_end_time is null");
            return (Criteria) this;
        }

        public Criteria andHolidayEndTimeIsNotNull() {
            addCriterion("holiday_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayEndTimeEqualTo(String value) {
            addCriterion("holiday_end_time =", value, "holidayEndTime");
            return (Criteria) this;
        }

        public Criteria andHolidayEndTimeNotEqualTo(String value) {
            addCriterion("holiday_end_time <>", value, "holidayEndTime");
            return (Criteria) this;
        }

        public Criteria andHolidayEndTimeGreaterThan(String value) {
            addCriterion("holiday_end_time >", value, "holidayEndTime");
            return (Criteria) this;
        }

        public Criteria andHolidayEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("holiday_end_time >=", value, "holidayEndTime");
            return (Criteria) this;
        }

        public Criteria andHolidayEndTimeLessThan(String value) {
            addCriterion("holiday_end_time <", value, "holidayEndTime");
            return (Criteria) this;
        }

        public Criteria andHolidayEndTimeLessThanOrEqualTo(String value) {
            addCriterion("holiday_end_time <=", value, "holidayEndTime");
            return (Criteria) this;
        }

        public Criteria andHolidayEndTimeLike(String value) {
            addCriterion("holiday_end_time like", value, "holidayEndTime");
            return (Criteria) this;
        }

        public Criteria andHolidayEndTimeNotLike(String value) {
            addCriterion("holiday_end_time not like", value, "holidayEndTime");
            return (Criteria) this;
        }

        public Criteria andHolidayEndTimeIn(List<String> values) {
            addCriterion("holiday_end_time in", values, "holidayEndTime");
            return (Criteria) this;
        }

        public Criteria andHolidayEndTimeNotIn(List<String> values) {
            addCriterion("holiday_end_time not in", values, "holidayEndTime");
            return (Criteria) this;
        }

        public Criteria andHolidayEndTimeBetween(String value1, String value2) {
            addCriterion("holiday_end_time between", value1, value2, "holidayEndTime");
            return (Criteria) this;
        }

        public Criteria andHolidayEndTimeNotBetween(String value1, String value2) {
            addCriterion("holiday_end_time not between", value1, value2, "holidayEndTime");
            return (Criteria) this;
        }

        public Criteria andHolidayHoursIsNull() {
            addCriterion("holiday_hours is null");
            return (Criteria) this;
        }

        public Criteria andHolidayHoursIsNotNull() {
            addCriterion("holiday_hours is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayHoursEqualTo(String value) {
            addCriterion("holiday_hours =", value, "holidayHours");
            return (Criteria) this;
        }

        public Criteria andHolidayHoursNotEqualTo(String value) {
            addCriterion("holiday_hours <>", value, "holidayHours");
            return (Criteria) this;
        }

        public Criteria andHolidayHoursGreaterThan(String value) {
            addCriterion("holiday_hours >", value, "holidayHours");
            return (Criteria) this;
        }

        public Criteria andHolidayHoursGreaterThanOrEqualTo(String value) {
            addCriterion("holiday_hours >=", value, "holidayHours");
            return (Criteria) this;
        }

        public Criteria andHolidayHoursLessThan(String value) {
            addCriterion("holiday_hours <", value, "holidayHours");
            return (Criteria) this;
        }

        public Criteria andHolidayHoursLessThanOrEqualTo(String value) {
            addCriterion("holiday_hours <=", value, "holidayHours");
            return (Criteria) this;
        }

        public Criteria andHolidayHoursLike(String value) {
            addCriterion("holiday_hours like", value, "holidayHours");
            return (Criteria) this;
        }

        public Criteria andHolidayHoursNotLike(String value) {
            addCriterion("holiday_hours not like", value, "holidayHours");
            return (Criteria) this;
        }

        public Criteria andHolidayHoursIn(List<String> values) {
            addCriterion("holiday_hours in", values, "holidayHours");
            return (Criteria) this;
        }

        public Criteria andHolidayHoursNotIn(List<String> values) {
            addCriterion("holiday_hours not in", values, "holidayHours");
            return (Criteria) this;
        }

        public Criteria andHolidayHoursBetween(String value1, String value2) {
            addCriterion("holiday_hours between", value1, value2, "holidayHours");
            return (Criteria) this;
        }

        public Criteria andHolidayHoursNotBetween(String value1, String value2) {
            addCriterion("holiday_hours not between", value1, value2, "holidayHours");
            return (Criteria) this;
        }

        public Criteria andHolidayDescIsNull() {
            addCriterion("holiday_desc is null");
            return (Criteria) this;
        }

        public Criteria andHolidayDescIsNotNull() {
            addCriterion("holiday_desc is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayDescEqualTo(String value) {
            addCriterion("holiday_desc =", value, "holidayDesc");
            return (Criteria) this;
        }

        public Criteria andHolidayDescNotEqualTo(String value) {
            addCriterion("holiday_desc <>", value, "holidayDesc");
            return (Criteria) this;
        }

        public Criteria andHolidayDescGreaterThan(String value) {
            addCriterion("holiday_desc >", value, "holidayDesc");
            return (Criteria) this;
        }

        public Criteria andHolidayDescGreaterThanOrEqualTo(String value) {
            addCriterion("holiday_desc >=", value, "holidayDesc");
            return (Criteria) this;
        }

        public Criteria andHolidayDescLessThan(String value) {
            addCriterion("holiday_desc <", value, "holidayDesc");
            return (Criteria) this;
        }

        public Criteria andHolidayDescLessThanOrEqualTo(String value) {
            addCriterion("holiday_desc <=", value, "holidayDesc");
            return (Criteria) this;
        }

        public Criteria andHolidayDescLike(String value) {
            addCriterion("holiday_desc like", value, "holidayDesc");
            return (Criteria) this;
        }

        public Criteria andHolidayDescNotLike(String value) {
            addCriterion("holiday_desc not like", value, "holidayDesc");
            return (Criteria) this;
        }

        public Criteria andHolidayDescIn(List<String> values) {
            addCriterion("holiday_desc in", values, "holidayDesc");
            return (Criteria) this;
        }

        public Criteria andHolidayDescNotIn(List<String> values) {
            addCriterion("holiday_desc not in", values, "holidayDesc");
            return (Criteria) this;
        }

        public Criteria andHolidayDescBetween(String value1, String value2) {
            addCriterion("holiday_desc between", value1, value2, "holidayDesc");
            return (Criteria) this;
        }

        public Criteria andHolidayDescNotBetween(String value1, String value2) {
            addCriterion("holiday_desc not between", value1, value2, "holidayDesc");
            return (Criteria) this;
        }

        public Criteria andWorkextStartTimeIsNull() {
            addCriterion("workext_start_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkextStartTimeIsNotNull() {
            addCriterion("workext_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkextStartTimeEqualTo(String value) {
            addCriterion("workext_start_time =", value, "workextStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkextStartTimeNotEqualTo(String value) {
            addCriterion("workext_start_time <>", value, "workextStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkextStartTimeGreaterThan(String value) {
            addCriterion("workext_start_time >", value, "workextStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkextStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("workext_start_time >=", value, "workextStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkextStartTimeLessThan(String value) {
            addCriterion("workext_start_time <", value, "workextStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkextStartTimeLessThanOrEqualTo(String value) {
            addCriterion("workext_start_time <=", value, "workextStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkextStartTimeLike(String value) {
            addCriterion("workext_start_time like", value, "workextStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkextStartTimeNotLike(String value) {
            addCriterion("workext_start_time not like", value, "workextStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkextStartTimeIn(List<String> values) {
            addCriterion("workext_start_time in", values, "workextStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkextStartTimeNotIn(List<String> values) {
            addCriterion("workext_start_time not in", values, "workextStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkextStartTimeBetween(String value1, String value2) {
            addCriterion("workext_start_time between", value1, value2, "workextStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkextStartTimeNotBetween(String value1, String value2) {
            addCriterion("workext_start_time not between", value1, value2, "workextStartTime");
            return (Criteria) this;
        }

        public Criteria andWorkextEndTimeIsNull() {
            addCriterion("workext_end_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkextEndTimeIsNotNull() {
            addCriterion("workext_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkextEndTimeEqualTo(String value) {
            addCriterion("workext_end_time =", value, "workextEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkextEndTimeNotEqualTo(String value) {
            addCriterion("workext_end_time <>", value, "workextEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkextEndTimeGreaterThan(String value) {
            addCriterion("workext_end_time >", value, "workextEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkextEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("workext_end_time >=", value, "workextEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkextEndTimeLessThan(String value) {
            addCriterion("workext_end_time <", value, "workextEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkextEndTimeLessThanOrEqualTo(String value) {
            addCriterion("workext_end_time <=", value, "workextEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkextEndTimeLike(String value) {
            addCriterion("workext_end_time like", value, "workextEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkextEndTimeNotLike(String value) {
            addCriterion("workext_end_time not like", value, "workextEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkextEndTimeIn(List<String> values) {
            addCriterion("workext_end_time in", values, "workextEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkextEndTimeNotIn(List<String> values) {
            addCriterion("workext_end_time not in", values, "workextEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkextEndTimeBetween(String value1, String value2) {
            addCriterion("workext_end_time between", value1, value2, "workextEndTime");
            return (Criteria) this;
        }

        public Criteria andWorkextEndTimeNotBetween(String value1, String value2) {
            addCriterion("workext_end_time not between", value1, value2, "workextEndTime");
            return (Criteria) this;
        }

        public Criteria andIsLegalDayIsNull() {
            addCriterion("is_legal_day is null");
            return (Criteria) this;
        }

        public Criteria andIsLegalDayIsNotNull() {
            addCriterion("is_legal_day is not null");
            return (Criteria) this;
        }

        public Criteria andIsLegalDayEqualTo(String value) {
            addCriterion("is_legal_day =", value, "isLegalDay");
            return (Criteria) this;
        }

        public Criteria andIsLegalDayNotEqualTo(String value) {
            addCriterion("is_legal_day <>", value, "isLegalDay");
            return (Criteria) this;
        }

        public Criteria andIsLegalDayGreaterThan(String value) {
            addCriterion("is_legal_day >", value, "isLegalDay");
            return (Criteria) this;
        }

        public Criteria andIsLegalDayGreaterThanOrEqualTo(String value) {
            addCriterion("is_legal_day >=", value, "isLegalDay");
            return (Criteria) this;
        }

        public Criteria andIsLegalDayLessThan(String value) {
            addCriterion("is_legal_day <", value, "isLegalDay");
            return (Criteria) this;
        }

        public Criteria andIsLegalDayLessThanOrEqualTo(String value) {
            addCriterion("is_legal_day <=", value, "isLegalDay");
            return (Criteria) this;
        }

        public Criteria andIsLegalDayLike(String value) {
            addCriterion("is_legal_day like", value, "isLegalDay");
            return (Criteria) this;
        }

        public Criteria andIsLegalDayNotLike(String value) {
            addCriterion("is_legal_day not like", value, "isLegalDay");
            return (Criteria) this;
        }

        public Criteria andIsLegalDayIn(List<String> values) {
            addCriterion("is_legal_day in", values, "isLegalDay");
            return (Criteria) this;
        }

        public Criteria andIsLegalDayNotIn(List<String> values) {
            addCriterion("is_legal_day not in", values, "isLegalDay");
            return (Criteria) this;
        }

        public Criteria andIsLegalDayBetween(String value1, String value2) {
            addCriterion("is_legal_day between", value1, value2, "isLegalDay");
            return (Criteria) this;
        }

        public Criteria andIsLegalDayNotBetween(String value1, String value2) {
            addCriterion("is_legal_day not between", value1, value2, "isLegalDay");
            return (Criteria) this;
        }

        public Criteria andWorkextHoursIsNull() {
            addCriterion("workext_hours is null");
            return (Criteria) this;
        }

        public Criteria andWorkextHoursIsNotNull() {
            addCriterion("workext_hours is not null");
            return (Criteria) this;
        }

        public Criteria andWorkextHoursEqualTo(String value) {
            addCriterion("workext_hours =", value, "workextHours");
            return (Criteria) this;
        }

        public Criteria andWorkextHoursNotEqualTo(String value) {
            addCriterion("workext_hours <>", value, "workextHours");
            return (Criteria) this;
        }

        public Criteria andWorkextHoursGreaterThan(String value) {
            addCriterion("workext_hours >", value, "workextHours");
            return (Criteria) this;
        }

        public Criteria andWorkextHoursGreaterThanOrEqualTo(String value) {
            addCriterion("workext_hours >=", value, "workextHours");
            return (Criteria) this;
        }

        public Criteria andWorkextHoursLessThan(String value) {
            addCriterion("workext_hours <", value, "workextHours");
            return (Criteria) this;
        }

        public Criteria andWorkextHoursLessThanOrEqualTo(String value) {
            addCriterion("workext_hours <=", value, "workextHours");
            return (Criteria) this;
        }

        public Criteria andWorkextHoursLike(String value) {
            addCriterion("workext_hours like", value, "workextHours");
            return (Criteria) this;
        }

        public Criteria andWorkextHoursNotLike(String value) {
            addCriterion("workext_hours not like", value, "workextHours");
            return (Criteria) this;
        }

        public Criteria andWorkextHoursIn(List<String> values) {
            addCriterion("workext_hours in", values, "workextHours");
            return (Criteria) this;
        }

        public Criteria andWorkextHoursNotIn(List<String> values) {
            addCriterion("workext_hours not in", values, "workextHours");
            return (Criteria) this;
        }

        public Criteria andWorkextHoursBetween(String value1, String value2) {
            addCriterion("workext_hours between", value1, value2, "workextHours");
            return (Criteria) this;
        }

        public Criteria andWorkextHoursNotBetween(String value1, String value2) {
            addCriterion("workext_hours not between", value1, value2, "workextHours");
            return (Criteria) this;
        }

        public Criteria andWorkextDescIsNull() {
            addCriterion("workext_desc is null");
            return (Criteria) this;
        }

        public Criteria andWorkextDescIsNotNull() {
            addCriterion("workext_desc is not null");
            return (Criteria) this;
        }

        public Criteria andWorkextDescEqualTo(String value) {
            addCriterion("workext_desc =", value, "workextDesc");
            return (Criteria) this;
        }

        public Criteria andWorkextDescNotEqualTo(String value) {
            addCriterion("workext_desc <>", value, "workextDesc");
            return (Criteria) this;
        }

        public Criteria andWorkextDescGreaterThan(String value) {
            addCriterion("workext_desc >", value, "workextDesc");
            return (Criteria) this;
        }

        public Criteria andWorkextDescGreaterThanOrEqualTo(String value) {
            addCriterion("workext_desc >=", value, "workextDesc");
            return (Criteria) this;
        }

        public Criteria andWorkextDescLessThan(String value) {
            addCriterion("workext_desc <", value, "workextDesc");
            return (Criteria) this;
        }

        public Criteria andWorkextDescLessThanOrEqualTo(String value) {
            addCriterion("workext_desc <=", value, "workextDesc");
            return (Criteria) this;
        }

        public Criteria andWorkextDescLike(String value) {
            addCriterion("workext_desc like", value, "workextDesc");
            return (Criteria) this;
        }

        public Criteria andWorkextDescNotLike(String value) {
            addCriterion("workext_desc not like", value, "workextDesc");
            return (Criteria) this;
        }

        public Criteria andWorkextDescIn(List<String> values) {
            addCriterion("workext_desc in", values, "workextDesc");
            return (Criteria) this;
        }

        public Criteria andWorkextDescNotIn(List<String> values) {
            addCriterion("workext_desc not in", values, "workextDesc");
            return (Criteria) this;
        }

        public Criteria andWorkextDescBetween(String value1, String value2) {
            addCriterion("workext_desc between", value1, value2, "workextDesc");
            return (Criteria) this;
        }

        public Criteria andWorkextDescNotBetween(String value1, String value2) {
            addCriterion("workext_desc not between", value1, value2, "workextDesc");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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