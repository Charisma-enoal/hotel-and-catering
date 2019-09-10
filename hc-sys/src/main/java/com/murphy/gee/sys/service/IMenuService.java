package com.murphy.gee.sys.service;

import com.murphy.gee.sys.entity.Menu;
import com.murphy.gee.sys.entity.Modules;

import java.util.List;

/**
 * @ClassName IMenuService
 * @Description 菜单接口
 * @Author Murphy.Gee
 * @Date 2019-08-09 15:17
 * @Version 1.0
 **/
public interface IMenuService {
    /*
     * @description: 获取到登录用户的菜单权限
     * @param userName
     * @return: java.util.List<com.murphy.gee.sys.entity.Menu>
     * @author: Murphy.Gee
     * @date: 2019-08-09 15:14
     */
    List<Modules> findMenuByUserName(String userName);
}
