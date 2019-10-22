package com.murphy.gee.sys.entity;

import java.util.List;

/**
 * @ClassName AuthListModel
 * @Description 权限列表实体
 * @Author Murphy.Gee
 * @Date 2019-09-12 11:55
 * @Version 1.0
 **/
public class AuthListModel {
    private Integer id;
    private String text;
    private Integer value;
    private String icon;
    private boolean opened;
    private boolean selected = false;
    private boolean disabled = false;
    private boolean loading = false;
    private List<AuthListModel> children;
    private boolean dragDisabled = false;
    private Integer level;
    private Integer moduleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isLoading() {
        return loading;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    public List<AuthListModel> getChildren() {
        return children;
    }

    public void setChildren(List<AuthListModel> children) {
        this.children = children;
    }

    public boolean isDragDisabled() {
        return dragDisabled;
    }

    public void setDragDisabled(boolean dragDisabled) {
        this.dragDisabled = dragDisabled;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
}
