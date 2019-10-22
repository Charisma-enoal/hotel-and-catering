package com.murphy.gee.sys.service.impl;

import com.murphy.gee.common.entity.DeptTreeSelect;
import com.murphy.gee.common.entity.MurphyResponseCode;
import com.murphy.gee.common.exception.MurphyException;
import com.murphy.gee.sys.entity.*;
import com.murphy.gee.sys.mapper.GroupMapper;
import com.murphy.gee.sys.mapper.GroupRoleMapper;
import com.murphy.gee.sys.mapper.UserGroupMapper;
import com.murphy.gee.sys.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    @Autowired
    GroupRoleMapper groupRoleMapper;
    @Autowired
    UserGroupMapper userGroupMapper;
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
    /*
     * @description: 保存部门
     * @param group
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-09-10 15:29
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public void save(Group group) {
        //判断groupId是否为空，为空表示新增部门，否则，表示修改部门
        if (null != group.getGroupId()){
            //修改部门
            //将部门角色映射关系删除(清除部门所属角色)
            GroupRoleExample example = new GroupRoleExample();
            example.createCriteria().andGroupIdEqualTo(group.getGroupId());
            groupRoleMapper.deleteByExample(example);
            //修改部门基本信息
            GroupExample groupExample = new GroupExample();
            groupExample.createCriteria().andGroupIdEqualTo(group.getGroupId());
            groupMapper.updateByExample(group,groupExample);

        }else{
            //新增部门
            groupMapper.insert(group);
        }
    }
    /*
     * @description: 根据部门ID获取部门详细信息
     * @param groupId
     * @return: com.murphy.gee.sys.entity.Group
     * @author: Murphy.Gee
     * @date: 2019-09-10 17:26
     */
    @Override
    public Group getGroupByGroupId(Integer groupId) {
        return groupMapper.selectByPrimaryKey(groupId.longValue());
    }

    /*
     * @description: 加载部门所拥有的角色
     * @param groupId
     * @return: java.util.List<java.lang.Long>
     * @author: Murphy.Gee
     * @date: 2019-09-10 17:58
     */
    @Override
    public List<Long> initDeptRoles(Integer groupId) {
        return groupRoleMapper.initDeptRoles(groupId.longValue());
    }
    /*
     * @description: 分配角色
     * @param groupId
     * @param roleIds
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-09-11 9:21
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public void allocationRoles(Integer groupId, String roleIds) {
        //删除此部门之前的角色
        GroupRoleExample groupRoleExample = new GroupRoleExample();
        groupRoleExample.createCriteria().andGroupIdEqualTo(groupId.longValue());
        groupRoleMapper.deleteByExample(groupRoleExample);

        //将以逗号分割的角色ID转换为数组
        String[] roleArr = roleIds.split(",");
        //循环数组，并组成批量插入的对象
        List<GroupRole> list = new ArrayList<GroupRole>();
        for (String role : roleArr) {
            GroupRole groupRole = new GroupRole();
            groupRole.setGroupId(groupId.longValue());
            groupRole.setRoleId(Long.parseLong(role));
            list.add(groupRole);
        }
        //批量插入
        groupRoleMapper.insertBatch(list);
    }
    /*
     * @description: 删除部门
     * @param groupId
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-09-11 9:33
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public void delete(Integer groupId) throws MurphyException {
        //查询该部门下是否存在子部门，如果存在，则不允许删除
        GroupExample groupExample = new GroupExample();
        groupExample.createCriteria().andGroupParentIdEqualTo(groupId.longValue());
        List<Group> groupList = groupMapper.selectByExample(groupExample);
        if (null != groupList && groupList.size() > 0){
            throw new MurphyException(MurphyResponseCode.VALIDATE_ERROR,"该部门下存在子部门，请先删除子部门");
        }

        //查询该部门下是否存在用户，如果存在用户，则不允许删除
        UserGroupExample userGroupExample = new UserGroupExample();
        userGroupExample.createCriteria().andGroupIdEqualTo(groupId.longValue());
        List<UserGroup> userGroupList = userGroupMapper.selectByExample(userGroupExample);
        if (null != userGroupList && userGroupList.size() > 0){
            throw new MurphyException(MurphyResponseCode.VALIDATE_ERROR,"该部门下存在用户，不允许删除");
        }

        //删除该部门与角色的映射关系
        GroupRoleExample groupRoleExample = new GroupRoleExample();
        groupRoleExample.createCriteria().andGroupIdEqualTo(groupId.longValue());
        groupRoleMapper.deleteByExample(groupRoleExample);

        //删除部门
        groupMapper.deleteByPrimaryKey(groupId.longValue());

    }
}
