package com.taotao.pojo;

public class TbFlow {
    private Integer flowId;

    private String flowStatus;

    private String flowType;

    private String flowName;

    private String flowOrder;

    private String holidayType;

    private String holidayStartTime;

    private String holidayEndTime;

    private String holidayHours;

    private String holidayDesc;

    private String workextStartTime;

    private String workextEndTime;

    private String isLegalDay;

    private String workextHours;

    private String workextDesc;

    private Integer userId;

    private String createTime;

    private String updateTime;

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public String getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus == null ? null : flowStatus.trim();
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType == null ? null : flowType.trim();
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName == null ? null : flowName.trim();
    }

    public String getFlowOrder() {
        return flowOrder;
    }

    public void setFlowOrder(String flowOrder) {
        this.flowOrder = flowOrder == null ? null : flowOrder.trim();
    }

    public String getHolidayType() {
        return holidayType;
    }

    public void setHolidayType(String holidayType) {
        this.holidayType = holidayType == null ? null : holidayType.trim();
    }

    public String getHolidayStartTime() {
        return holidayStartTime;
    }

    public void setHolidayStartTime(String holidayStartTime) {
        this.holidayStartTime = holidayStartTime == null ? null : holidayStartTime.trim();
    }

    public String getHolidayEndTime() {
        return holidayEndTime;
    }

    public void setHolidayEndTime(String holidayEndTime) {
        this.holidayEndTime = holidayEndTime == null ? null : holidayEndTime.trim();
    }

    public String getHolidayHours() {
        return holidayHours;
    }

    public void setHolidayHours(String holidayHours) {
        this.holidayHours = holidayHours == null ? null : holidayHours.trim();
    }

    public String getHolidayDesc() {
        return holidayDesc;
    }

    public void setHolidayDesc(String holidayDesc) {
        this.holidayDesc = holidayDesc == null ? null : holidayDesc.trim();
    }

    public String getWorkextStartTime() {
        return workextStartTime;
    }

    public void setWorkextStartTime(String workextStartTime) {
        this.workextStartTime = workextStartTime == null ? null : workextStartTime.trim();
    }

    public String getWorkextEndTime() {
        return workextEndTime;
    }

    public void setWorkextEndTime(String workextEndTime) {
        this.workextEndTime = workextEndTime == null ? null : workextEndTime.trim();
    }

    public String getIsLegalDay() {
        return isLegalDay;
    }

    public void setIsLegalDay(String isLegalDay) {
        this.isLegalDay = isLegalDay == null ? null : isLegalDay.trim();
    }

    public String getWorkextHours() {
        return workextHours;
    }

    public void setWorkextHours(String workextHours) {
        this.workextHours = workextHours == null ? null : workextHours.trim();
    }

    public String getWorkextDesc() {
        return workextDesc;
    }

    public void setWorkextDesc(String workextDesc) {
        this.workextDesc = workextDesc == null ? null : workextDesc.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}