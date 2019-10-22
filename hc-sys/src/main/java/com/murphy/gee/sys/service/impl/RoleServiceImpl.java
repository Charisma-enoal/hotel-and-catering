package com.murphy.gee.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.murphy.gee.common.entity.MurphyResponseCode;
import com.murphy.gee.common.exception.MurphyException;
import com.murphy.gee.common.util.StringUtils;
import com.murphy.gee.sys.entity.Role;
import com.murphy.gee.sys.entity.RoleAuthorityExample;
import com.murphy.gee.sys.entity.RoleExample;
import com.murphy.gee.sys.mapper.GroupRoleMapper;
import com.murphy.gee.sys.mapper.RoleAuthorityMapper;
import com.murphy.gee.sys.mapper.RoleMapper;
import com.murphy.gee.sys.mapper.UserRoleMapper;
import com.murphy.gee.sys.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RoleServiceImpl
 * @Description 角色相关实现类
 * @Author Murphy.Gee
 * @Date 2019-09-06 16:28
 * @Version 1.0
 **/
@Service("roleService")
public class RoleServiceImpl implements IRoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    GroupRoleMapper groupRoleMapper;
    @Autowired
    RoleAuthorityMapper roleAuthorityMapper;

    /*
     * @description: 获取所有角色
     * @param
     * @return: java.util.List<com.murphy.gee.sys.entity.Role>
     * @author: Murphy.Gee
     * @date: 2019-09-06 16:29
     */
    @Override
    public List<Role> allList() {
        return roleMapper.selectByExample(new RoleExample());
    }

    @Override
    public PageInfo<Role> list(Integer pageSize, Integer pageNum, String keyword, Integer roleEnable) {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        if (StringUtils.isNotEmpty(keyword)){
            criteria.andRoleNameLike(keyword);
        }
        if (null != roleEnable){
            criteria.andRoleEnableEqualTo(roleEnable);
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Role> roleList = roleMapper.selectByExample(roleExample);
        PageInfo<Role> pageInfo = new PageInfo<Role>(roleList);
        return pageInfo;
    }
    /*
     * @description: 保存角色
     * @param role
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-10-11 17:16
     */
    @Override
    public void save(Role role) {
        if (null != role.getRoleId()){
            //修改角色
            roleMapper.updateByPrimaryKey(role);
        }else{
            //新增角色
            roleMapper.insert(role);
        }
    }
    /*
     * @description: 初始化角色
     * @param roleId
     * @return: com.murphy.gee.sys.entity.Role
     * @author: Murphy.Gee
     * @date: 2019-10-14 11:14
     */
    @Override
    public Role initRole(Long roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }
    /*
     * @description: 修改角色状态
     * @param roleId
     * @param roleEnable
     * @return: int
     * @author: Murphy.Gee
     * @date: 2019-10-14 11:28
     */
    @Override
    public int updateStatus(Long roleId, Integer roleEnable) {
        Role role = new Role();
        role.setRoleId(roleId);
        role.setRoleEnable(roleEnable);
        return roleMapper.updateByPrimaryKeySelective(role);
    }
    /*
     * @description: 删除角色
     * @param roleId
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-10-14 11:45
     */
    @Override
    public void delete(Long roleId) throws MurphyException {
        // 首先，查询是否有部门或者用户用到了此角色
        Integer userRoleCount = userRoleMapper.countByRoleId(roleId);
        Integer deptRoleCount = groupRoleMapper.countByRoleId(roleId);
        // 如果用户或部门用到了此角色，则不允许删除
        if (userRoleCount > 0){
            throw new MurphyException(MurphyResponseCode.VALIDATE_ERROR,"存在用到此角色的用户，不允许删除");
        }
        if (deptRoleCount > 0){
            throw new MurphyException(MurphyResponseCode.VALIDATE_ERROR,"存在用到此角色的部门，不允许删除");
        }
        // 删除角色对应的权限
        RoleAuthorityExample roleAuthorityExample = new RoleAuthorityExample();
        roleAuthorityExample.createCriteria().andRoleIdEqualTo(roleId);
        roleAuthorityMapper.deleteByExample(roleAuthorityExample);
        // 删除角色
        roleMapper.deleteByPrimaryKey(roleId);
    }
    /*
     * @description: 分配权限
     * @param roleId
     * @param authStr
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-10-18 17:12
     */
    @Override
    public void allotAuth(Long roleId, String authStr) {
        // 删除此角色的所有权限
        RoleAuthorityExample roleAuthorityExample = new RoleAuthorityExample();
        roleAuthorityExample.createCriteria().andRoleIdEqualTo(roleId);
        roleAuthorityMapper.deleteByExample(roleAuthorityExample);

        // 解析权限ID
        String[] authArr = authStr.split(",");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("roleId",roleId);
        map.put("authArr",authArr);

        // 给此角色分配权限
        roleAuthorityMapper.insertBatch(map);
    }
}
