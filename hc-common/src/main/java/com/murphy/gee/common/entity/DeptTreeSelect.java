package com.murphy.gee.common.entity;



import java.util.List;

/**
 * @ClassName DeptTreeSelect
 * @Description 部门选择树
 * @Author Murphy.Gee
 * @Date 2019-09-05 16:24
 * @Version 1.0
 **/
public class DeptTreeSelect {

    private Integer id;
    private String label;
    private Integer parent;
    private boolean expand;
    private List<DeptTreeSelect> children;

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

    public List<DeptTreeSelect> getChildren() {
        return children;
    }

    public void setChildren(List<DeptTreeSelect> children) {
        this.children = children;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public boolean isExpand() {
        return parent == 0 ? true : false;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }
}
