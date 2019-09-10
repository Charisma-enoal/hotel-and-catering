package com.murphy.gee.sys.entity;

import java.util.Date;
import java.util.List;

public class Modules {
    private Long modulesId;

    private String modulesName;

    private String modulesRemark;

    private Integer modulesOrder;

    private Date createDate;

    private String createPerson;

    private Date lastEditDate;

    private String lastEditPerson;

    private List<Menu> menuList;

    public Long getModulesId() {
        return modulesId;
    }

    public void setModulesId(Long modulesId) {
        this.modulesId = modulesId;
    }

    public String getModulesName() {
        return modulesName;
    }

    public void setModulesName(String modulesName) {
        this.modulesName = modulesName == null ? null : modulesName.trim();
    }

    public String getModulesRemark() {
        return modulesRemark;
    }

    public void setModulesRemark(String modulesRemark) {
        this.modulesRemark = modulesRemark == null ? null : modulesRemark.trim();
    }

    public Integer getModulesOrder() {
        return modulesOrder;
    }

    public void setModulesOrder(Integer modulesOrder) {
        this.modulesOrder = modulesOrder;
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

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}