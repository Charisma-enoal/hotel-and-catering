package com.murphy.gee.sys.service.impl;

import com.murphy.gee.common.entity.AuthTreeSelect;
import com.murphy.gee.sys.entity.*;
import com.murphy.gee.sys.mapper.*;
import com.murphy.gee.sys.service.IAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName AuthorityServiceImpl
 * @Description 权限模块的实现类
 * @Author Murphy.Gee
 * @Date 2019-08-07 17:53
 * @Version 1.0
 **/
@Service("authorityService")
public class AuthorityServiceImpl implements IAuthorityService {
    @Autowired
    private AuthorityMapper authorityMapper;
    @Autowired
    private ModulesMapper modulesMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private ActionMapper actionMapper;
    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;

    /*
     * @description: 根据用户名获取到用户的所有权限
     * @param userName
     * @return: java.util.List<com.murphy.gee.sys.entity.Authority>
     * @author: Murphy.Gee
     * @date: 2019-08-07 17:47
     */
    @Cacheable(value = "auth_info",key = "'auth_info_' + #userName")
    @Override
    public List<Authority> selectAuthByUsername(String userName) {
        return authorityMapper.selectAuthByUsername(userName);
    }
    /*
     * @description: 权限配置列表
     * @param
     * @return: java.util.List<com.murphy.gee.sys.entity.AuthListModel>
     * @author: Murphy.Gee
     * @date: 2019-09-12 12:10
     */
    @Override
    public List<AuthListModel> findAllAuth() {
        AuthListModel authListModel = new AuthListModel();
        authListModel.setId(0);
        authListModel.setLevel(-1);
        authListModel.setIcon("ivu-icon ivu-icon-ios-albums");
        authListModel.setOpened(true);
        authListModel.setText("Root");
        authListModel.setValue(-1);
        //查到所有的模块
        List<AuthListModel> modules =  modulesMapper.findAllModules();
        //循环模块，查询模块的菜单
        if (null != modules && modules.size() > 0){
            for (AuthListModel model : modules) {
                List<AuthListModel> menuList = menuMapper.findAuthByModuleId(model.getId());
                //循环菜单，查询菜单下的操作权限
                List<AuthListModel> menus = recursionMenu(menuList);
                model.setChildren(menus);
            }
        }
        authListModel.setChildren(modules);
        List<AuthListModel> allList = new ArrayList<AuthListModel>();
        allList.add(authListModel);
        return allList;
    }
    /*
     * @description: 初始化权限选择树
     * @param
     * @return: java.util.List<com.murphy.gee.common.entity.AuthTreeSelect>
     * @author: Murphy.Gee
     * @date: 2019-10-14 15:27
     */
    @Override
    public List<AuthTreeSelect> initAuthTreeSelect() {
        // 查询出所有模块
        List<AuthTreeSelect> modulesList = modulesMapper.findAllModulesForAuth();
        // 循环模块
        if (null != modulesList && modulesList.size() > 0){
            for (AuthTreeSelect authTree :
                    modulesList) {
                List<AuthTreeSelect> menuList = menuMapper.getMenuForAuthByModulesId(authTree.getElementId());
                menuList.stream().forEach(m -> m.setParent(authTree.getElementId()));
                List<AuthTreeSelect> actionList = recursionMenuForAuth(menuList);
                authTree.setChildren(actionList);
            }
        }
        return modulesList;
    }

    /*
     * @description: 根据角色ID获取到该角色所拥有的权限
     * @param roleId
     * @return: java.util.List<java.lang.Long>
     * @author: Murphy.Gee
     * @date: 2019-10-18 16:56
     */
    @Override
    public List<Long> findAuthByRoleId(Long roleId) {
        RoleAuthorityExample roleAuthorityExample = new RoleAuthorityExample();
        roleAuthorityExample.createCriteria().andRoleIdEqualTo(roleId);
        List<RoleAuthority> authorityList = roleAuthorityMapper.selectByExample(roleAuthorityExample);
        List<Long> list = authorityList.stream().map(o -> o.getAuthId()).collect(Collectors.toList());
        return list;
    }

    private List<AuthTreeSelect> recursionMenuForAuth(List<AuthTreeSelect> list){
        if (null != list && list.size() > 0){
            for (AuthTreeSelect menu : list) {
                if (null != menu.getChildren() && menu.getChildren().size() > 0){
                    List<AuthTreeSelect> menuList = recursionMenuForAuth(menu.getChildren());
                }else{
                    List<AuthTreeSelect> actionList = actionMapper.findAuthTreeForMenuId(menu.getElementId());
                    menu.setChildren(actionList);
                }
            }
        }
        return list;
    }

    private List<AuthListModel> recursionMenu(List<AuthListModel> menuList){
        if (null != menuList && menuList.size() > 0){
            for (AuthListModel menu : menuList) {
                if (null != menu.getChildren() && menu.getChildren().size() > 0){
                    List<AuthListModel> list = recursionMenu(menu.getChildren());
                }else{
                    List<AuthListModel> actionList = actionMapper.findListByMenuId(menu.getId());
                    menu.setChildren(actionList);
                }
            }
        }
        return menuList;
    }
}
