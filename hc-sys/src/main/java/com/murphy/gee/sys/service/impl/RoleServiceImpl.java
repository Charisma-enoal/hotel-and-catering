package com.murphy.gee.sys.service.impl;

import com.murphy.gee.sys.entity.Role;
import com.murphy.gee.sys.entity.RoleExample;
import com.murphy.gee.sys.mapper.RoleMapper;
import com.murphy.gee.sys.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
