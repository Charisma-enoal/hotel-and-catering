package com.murphy.gee.sys.service.impl;

import com.murphy.gee.common.entity.DeptTreeSelect;
import com.murphy.gee.sys.mapper.GroupMapper;
import com.murphy.gee.sys.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DepartmentServiceImpl
 * @Description 部门实现类
 * @Author Murphy.Gee
 * @Date 2019-09-05 16:31
 * @Version 1.0
 **/
@Service("departmentService")
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    GroupMapper groupMapper;
    /*
     * @description: 部门下拉选择树
     * @param parentId
     * @return: java.util.List<com.murphy.gee.common.entity.DeptTreeSelect>
     * @author: Murphy.Gee
     * @date: 2019-09-05 16:57
     */
    @Override
    public List<DeptTreeSelect> getDeptTree() {
        return groupMapper.getDeptTree(0);
    }
}
