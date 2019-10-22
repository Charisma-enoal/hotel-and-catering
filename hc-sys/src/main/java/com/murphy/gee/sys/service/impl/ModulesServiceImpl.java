package com.murphy.gee.sys.service.impl;

import com.murphy.gee.common.entity.MurphyResponseCode;
import com.murphy.gee.common.exception.MurphyException;
import com.murphy.gee.sys.entity.*;
import com.murphy.gee.sys.mapper.AuthorityMapper;
import com.murphy.gee.sys.mapper.AuthorityModulesMapper;
import com.murphy.gee.sys.mapper.MenuMapper;
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
    @Autowired
    private AuthorityMapper authorityMapper;
    @Autowired
    private AuthorityModulesMapper authorityModulesMapper;
    @Autowired
    private MenuMapper menuMapper;

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
    /*
     * @description: 保存模块
     * @param modules
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-10-08 11:53
     */
    @Override
    public void saveModules(Modules modules) throws MurphyException {
        if (null != modules.getModulesId()){
            modulesMapper.updateByPrimaryKey(modules);
        }else{
            Integer modulesKey = modulesMapper.insert(modules);
            Authority authority = new Authority();
            authority.setAuthType("1");
            Integer key = authorityMapper.insert(authority);
            AuthorityModules authorityModules = new AuthorityModules();
            authorityModules.setAuthId(key.longValue());
            authorityModules.setModulesId(modulesKey.longValue());
            authorityModulesMapper.insert(authorityModules);
        }
    }
    /*
     * @description:查看
     * @param modulesId
     * @return: com.murphy.gee.sys.entity.Modules
     * @author: Murphy.Gee
     * @date: 2019-10-08 15:26
     */
    @Override
    public Modules view(Long modulesId) {
        return modulesMapper.selectByPrimaryKey(modulesId);
    }
    /*
     * @description: 删除
     * @param modulesId
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-10-08 17:32
     */
    @Override
    public void delete(Long modulesId) throws MurphyException {
       // 查询该模块下是否包含菜单
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria().andModulesIdEqualTo(modulesId);
        List<Menu> menuList = menuMapper.selectByExample(menuExample);
        // 如果模块下存在菜单，不允许删除
        if (null != menuList && menuList.size() > 0){
            throw new MurphyException(MurphyResponseCode.VALIDATE_ERROR,"该模块下存在菜单，不允许删除");
        }

        // 删除模块
        modulesMapper.deleteByPrimaryKey(modulesId);
        AuthorityModulesExample authorityModulesExample = new AuthorityModulesExample();
        authorityModulesExample.createCriteria().andModulesIdEqualTo(modulesId);
        // 查询出authID
        List<AuthorityModules> authorityModulesList = authorityModulesMapper.selectByExample(authorityModulesExample);
        Long authId = new Long(0);
        if (null != authorityModulesList && authorityModulesList.size() > 0){
            authId = authorityModulesList.get(0).getAuthId();
        }
        // 删除关联信息
        authorityModulesMapper.deleteByExample(authorityModulesExample);

        // 删除auth
        authorityMapper.deleteByPrimaryKey(authId);
    }
}
