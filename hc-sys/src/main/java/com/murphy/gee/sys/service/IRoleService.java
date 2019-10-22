package com.murphy.gee.sys.service;

import com.github.pagehelper.PageInfo;
import com.murphy.gee.common.exception.MurphyException;
import com.murphy.gee.sys.entity.Role;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IRoleService {
    List<Role> allList();

    PageInfo<Role> list(Integer pageSize, Integer pageNum, String keyword, Integer roleEnable);

    /*
     * @description: 保存角色
     * @param role
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-10-11 17:16
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    void save(Role role);

    /*
     * @description: 初始化角色
     * @param roleId
     * @return: com.murphy.gee.sys.entity.Role
     * @author: Murphy.Gee
     * @date: 2019-10-14 11:14
     */
    Role initRole(Long roleId);

    /*
     * @description: 修改角色状态
     * @param roleId
     * @param roleEnable
     * @return: int
     * @author: Murphy.Gee
     * @date: 2019-10-14 11:28
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    int updateStatus(Long roleId,Integer roleEnable);
    /*
     * @description: 删除角色
     * @param roleId
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-10-14 11:45
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    void delete(Long roleId) throws MurphyException;

    /*
     * @description: 分配权限
     * @param roleId
     * @param authStr
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-10-18 17:12
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    void allotAuth(Long roleId,String authStr);
}
