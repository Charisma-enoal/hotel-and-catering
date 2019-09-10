package com.murphy.gee.sys.service;

import com.murphy.gee.sys.entity.Modules;

import java.util.List;

public interface IModulesService {
    /*
     * @description: 根据用户名查询该用户所拥有的模块权限
     * @param userName
     * @return: java.util.List<com.murphy.gee.sys.entity.Modules>
     * @author: Murphy.Gee
     * @date: 2019-08-09 14:50
     */
    List<Modules> findModulesByUserName(String userName);
}
