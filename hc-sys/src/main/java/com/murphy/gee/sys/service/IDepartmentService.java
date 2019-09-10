package com.murphy.gee.sys.service;

import com.murphy.gee.common.entity.DeptTreeSelect;

import java.util.List;

public interface IDepartmentService {
    List<DeptTreeSelect> getDeptTree();
}
