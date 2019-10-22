package com.murphy.gee.sys.service;

import com.murphy.gee.common.entity.AuthTreeSelect;
import com.murphy.gee.sys.entity.AuthListModel;
import com.murphy.gee.sys.entity.Authority;

import java.util.List;

public interface IAuthorityService {
    /*
     * @description: 根据用户名获取到用户的所有权限
     * @param userName
     * @return: java.util.List<com.murphy.gee.sys.entity.Authority>
     * @author: Murphy.Gee
     * @date: 2019-08-07 17:47
     */
    List<Authority> selectAuthByUsername(String userName);

    /*
     * @description: 权限配置列表
     * @param
     * @return: java.util.List<com.murphy.gee.sys.entity.AuthListModel>
     * @author: Murphy.Gee
     * @date: 2019-09-12 12:10
     */
    List<AuthListModel> findAllAuth();

    /*
     * @description: 初始化权限选择树
     * @param
     * @return: java.util.List<com.murphy.gee.common.entity.AuthTreeSelect>
     * @author: Murphy.Gee
     * @date: 2019-10-14 15:27
     */
    List<AuthTreeSelect> initAuthTreeSelect();

    /*
     * @description: 根据角色ID获取到该角色所拥有的权限
     * @param roleId
     * @return: java.util.List<java.lang.Long>
     * @author: Murphy.Gee
     * @date: 2019-10-18 16:56
     */
    List<Long> findAuthByRoleId(Long roleId);
}
