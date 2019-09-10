package com.murphy.gee.sys.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class User {
    private Long userId;

    private String userName;

    private String userRealName;

    private String userPassword;

    private Integer userEnable;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    private String createPerson;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastEditDate;

    private String lastEditPerson;

    private Integer deptId;

    private String deptName;

    private String roleIds;

    private String roleNames;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName == null ? null : userRealName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserEnable() {
        return userEnable;
    }

    public void setUserEnable(Integer userEnable) {
        this.userEnable = userEnable;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    public Date getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public String getLastEditPerson() {
        return lastEditPerson;
    }

    public void setLastEditPerson(String lastEditPerson) {
        this.lastEditPerson = lastEditPerson == null ? null : lastEditPerson.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }
}