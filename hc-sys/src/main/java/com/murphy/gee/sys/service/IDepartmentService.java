package com.murphy.gee.sys.service;

import com.murphy.gee.common.entity.DeptTreeSelect;
import com.murphy.gee.common.exception.MurphyException;
import com.murphy.gee.sys.entity.Group;

import java.util.List;

public interface IDepartmentService {
    List<DeptTreeSelect> getDeptTree();
    /*
     * @description: 保存部门
     * @param group
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-09-10 15:29
     */
    void save(Group group);

    /*
     * @description: 根据部门ID获取部门详细信息
     * @param groupId
     * @return: com.murphy.gee.sys.entity.Group
     * @author: Murphy.Gee
     * @date: 2019-09-10 17:26
     */
    Group getGroupByGroupId(Integer groupId);

    /*
     * @description: 加载部门所拥有的角色
     * @param groupId
     * @return: java.util.List<java.lang.Long>
     * @author: Murphy.Gee
     * @date: 2019-09-10 17:58
     */
    List<Long> initDeptRoles(Integer groupId);

    /*
     * @description: 分配角色
     * @param groupId
     * @param roleIds
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-09-11 9:21
     */
    void allocationRoles(Integer groupId,String roleIds);

    /*
     * @description: 删除部门
     * @param groupId
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-09-11 9:33
     */
    void delete(Integer groupId) throws MurphyException;
}
