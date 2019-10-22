package com.murphy.gee.sys.service.impl;

import com.murphy.gee.common.entity.MurphyResponseCode;
import com.murphy.gee.common.exception.MurphyException;
import com.murphy.gee.sys.entity.*;
import com.murphy.gee.sys.mapper.*;
import com.murphy.gee.sys.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MenuServiceImpl
 * @Description 菜单实现类
 * @Author Murphy.Gee
 * @Date 2019-08-09 15:48
 * @Version 1.0
 **/
@Service("menuService")
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private ModulesMapper modulesMapper;

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private AuthorityMapper authorityMapper;
    @Autowired
    private AuthorityMenuMapper authorityMenuMapper;
    @Autowired
    private ActionMapper actionMapper;
    /*
     * @description: 获取到登录用户的菜单权限
     * @param userName
     * @return: java.util.List<com.murphy.gee.sys.entity.Menu>
     * @author: Murphy.Gee
     * @date: 2019-08-09 15:14
     */
    @Cacheable(value = "menu_list",key = "'menu_list_' + #userName")
    @Override
    public List<Modules> findMenuByUserName(String userName) {
        List<Modules> modulesList = modulesMapper.findModulesByUserName(userName);
        if (null != modulesList && modulesList.size() > 0){
            for (Modules m : modulesList) {
                List<Menu> menuList = menuMapper.findMenuByModulesId(m.getModulesId());
                if (null != menuList && menuList.size() > 0){
                    m.setMenuList(menuList);
                }
            }
        }
        return modulesList;
    }
    /*
     * @description: 新增菜单
     * @param menu
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-10-08 14:12
     */
    @Override
    public void save(Menu menu) throws MurphyException {
        if (null != menu.getMenuId()){
            menuMapper.updateByPrimaryKey(menu);
        }else{
            Integer menuKey = menuMapper.insert(menu);
            Authority authority = new Authority();
            authority.setAuthType("2");
            Integer key = authorityMapper.insert(authority);
            AuthorityMenu authorityMenu = new AuthorityMenu();
            authorityMenu.setAuthId(key.longValue());
            authorityMenu.setMenuId(menuKey.longValue());
            authorityMenuMapper.insert(authorityMenu);
        }
    }
    /*
     * @description: 查看
     * @param menuId
     * @return: com.murphy.gee.sys.entity.Menu
     * @author: Murphy.Gee
     * @date: 2019-10-08 15:24
     */
    @Override
    public Menu view(Long menuId) {
        return menuMapper.selectByPrimaryKey(menuId);
    }

    /*
     * @description: 删除
     * @param menuId
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-10-08 17:00
     */
    @Override
    public void delete(Long menuId) throws MurphyException {
        // 查询该菜单是否有子菜单
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria().andMenuParentIdEqualTo(menuId);
        List<Menu> menuList = menuMapper.selectByExample(menuExample);
        // 如果存在子菜单，不允许删除，并提示
        if (null != menuList && menuList.size() > 0){
            throw new MurphyException(MurphyResponseCode.VALIDATE_ERROR,"该菜单存在子菜单，不允许删除");
        }


        // 查询该菜单下是否包含操作权限
        ActionExample actionExample = new ActionExample();
        actionExample.createCriteria().andMenuIdEqualTo(menuId);
        List<Action> actionList = actionMapper.selectByExample(actionExample);
        // 如果包含操作权限，不允许删除，并提示
        if (null != actionList && actionList.size() > 0){
            throw new MurphyException(MurphyResponseCode.VALIDATE_ERROR,"该菜单包含操作权限，不允许删除");
        }

        // 删除菜单
        menuMapper.deleteByPrimaryKey(menuId);
        // 根据菜单ID删除关联表
        AuthorityMenuExample authorityMenuExample = new AuthorityMenuExample();
        authorityMenuExample.createCriteria().andMenuIdEqualTo(menuId);
        // 查询出对应的authId
        List<AuthorityMenu> authorityMenuList = authorityMenuMapper.selectByExample(authorityMenuExample);
        // 定义authId
        Long authId = new Long(0);
        if (null != authorityMenuList && authorityMenuList.size() > 0){
            authId = authorityMenuList.get(0).getAuthId();
        }
        authorityMenuMapper.deleteByExample(authorityMenuExample);

        // 删除权限
        authorityMapper.deleteByPrimaryKey(authId);
    }
}
