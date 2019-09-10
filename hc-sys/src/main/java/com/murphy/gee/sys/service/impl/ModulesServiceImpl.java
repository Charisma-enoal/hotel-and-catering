package com.murphy.gee.sys.service.impl;

import com.murphy.gee.sys.entity.Modules;
import com.murphy.gee.sys.mapper.ModulesMapper;
import com.murphy.gee.sys.service.IModulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ModulesServiceImpl
 * @Description 模块服务层实现
 * @Author Murphy.Gee
 * @Date 2019-08-09 14:55
 * @Version 1.0
 **/
@Service("modulesService")
public class ModulesServiceImpl implements IModulesService {
    @Autowired
    private ModulesMapper modulesMapper;

    /*
     * @description: 根据用户名查询该用户所拥有的模块权限
     * @param userName
     * @return: java.util.List<com.murphy.gee.sys.entity.Modules>
     * @author: Murphy.Gee
     * @date: 2019-08-09 14:50
     */
    @Cacheable(value = "modules_list",key = "'modules_list_' + #userName")
    @Override
    public List<Modules> findModulesByUserName(String userName) {
        return modulesMapper.findModulesByUserName(userName);
    }
}
