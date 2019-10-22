package com.murphy.gee.common.entity;

import java.util.List;

/**
 * @ClassName AuthTreeSelect
 * @Description 权限选择树
 * @Author Murphy.Gee
 * @Date 2019-10-14 15:26
 * @Version 1.0
 **/
public class AuthTreeSelect {
    private Integer id;
    private String label;
    private Integer parent;
    private boolean expand = false;
    private Integer elementId;
    private List<AuthTreeSelect> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }

    public List<AuthTreeSelect> getChildren() {
        return children;
    }

    public void setChildren(List<AuthTreeSelect> children) {
        this.children = children;
    }

    public Integer getElementId() {
        return elementId;
    }

    public void setElementId(Integer elementId) {
        this.elementId = elementId;
    }
}
