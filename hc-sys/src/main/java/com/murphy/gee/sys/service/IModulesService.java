package com.murphy.gee.sys.service;

import com.murphy.gee.common.exception.MurphyException;
import com.murphy.gee.sys.entity.Modules;
import org.springframework.transaction.annotation.Transactional;

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

    /*
     * @description: 保存模块
     * @param modules
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-10-08 11:53
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    void saveModules(Modules modules) throws MurphyException;

    /*
     * @description:查看
     * @param modulesId
     * @return: com.murphy.gee.sys.entity.Modules
     * @author: Murphy.Gee
     * @date: 2019-10-08 15:26
     */
    Modules view(Long modulesId);

    /*
     * @description: 删除
     * @param modulesId
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-10-08 17:32
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    void delete(Long modulesId) throws MurphyException;
}
