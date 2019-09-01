package com.taotao.pojo;

public class TbDept {
    private Integer deptId;

    private String deptAddr;

    private String deptName;

    private String deptmanager;

    private Integer upDeptId;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptAddr() {
        return deptAddr;
    }

    public void setDeptAddr(String deptAddr) {
        this.deptAddr = deptAddr == null ? null : deptAddr.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDeptmanager() {
        return deptmanager;
    }

    public void setDeptmanager(String deptmanager) {
        this.deptmanager = deptmanager == null ? null : deptmanager.trim();
    }

    public Integer getUpDeptId() {
        return upDeptId;
    }

    public void setUpDeptId(Integer upDeptId) {
        this.upDeptId = upDeptId;
    }
}