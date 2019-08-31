package com.taotao.pojo;

public class TbRole {
    private Long roleId;

    private String roleName;

    private Integer roleDesc;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Integer getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(Integer roleDesc) {
        this.roleDesc = roleDesc;
    }
}