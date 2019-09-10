package com.murphy.gee.sys.entity;

public class Role {
    private Long roleId;

    private String roleName;

    private Integer roleEnable;

    private String roleRemark;

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

    public Integer getRoleEnable() {
        return roleEnable;
    }

    public void setRoleEnable(Integer roleEnable) {
        this.roleEnable = roleEnable;
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark == null ? null : roleRemark.trim();
    }
}