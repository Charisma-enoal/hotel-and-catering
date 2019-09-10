package com.murphy.gee.sys.service.impl;

import com.murphy.gee.sys.entity.Menu;
import com.murphy.gee.sys.entity.Modules;
import com.murphy.gee.sys.mapper.MenuMapper;
import com.murphy.gee.sys.mapper.ModulesMapper;
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
}
