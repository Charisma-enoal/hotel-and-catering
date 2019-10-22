package com.murphy.gee.sys.service;

import com.murphy.gee.common.exception.MurphyException;
import com.murphy.gee.sys.entity.Menu;
import com.murphy.gee.sys.entity.Modules;
import org.springframework.transaction.annotation.Transactional;

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

    /*
     * @description: 新增菜单
     * @param menu
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-10-08 14:12
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    void save(Menu menu) throws MurphyException;

    /*
     * @description: 查看
     * @param menuId
     * @return: com.murphy.gee.sys.entity.Menu
     * @author: Murphy.Gee
     * @date: 2019-10-08 15:24
     */
    Menu view(Long menuId);
    /*
     * @description: 删除
     * @param menuId
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-10-08 17:00
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    void delete(Long menuId) throws MurphyException;
}
