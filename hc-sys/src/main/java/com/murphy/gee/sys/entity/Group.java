package com.murphy.gee.sys.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
@ApiModel(value = "部门对象",description = "用于部门管理操作的对象")
public class Group {
    @ApiModelProperty(value = "主键ID",example = "1")
    private Long groupId;
    @ApiModelProperty(value = "部门名称")
    private String groupName;
    @ApiModelProperty(value = "父级部门ID",example = "1")
    private Long groupParentId;
    @ApiModelProperty(value = "部门备注")
    private String groupRemark;
    @ApiModelProperty(value = "创建时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @ApiModelProperty(value = "创建人")
    private String createPerson;
    @ApiModelProperty(value = "最后操作时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastEditDate;
    @ApiModelProperty(value = "最后操作人")
    private String lastEditPerson;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Long getGroupParentId() {
        return groupParentId;
    }

    public void setGroupParentId(Long groupParentId) {
        this.groupParentId = groupParentId;
    }

    public String getGroupRemark() {
        return groupRemark;
    }

    public void setGroupRemark(String groupRemark) {
        this.groupRemark = groupRemark == null ? null : groupRemark.trim();
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
}