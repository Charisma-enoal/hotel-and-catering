package com.murphy.gee.sys.mapper;

import com.murphy.gee.sys.entity.Menu;
import com.murphy.gee.sys.entity.MenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("menuMapper")
public interface MenuMapper {
    long countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(Long menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Long menuId);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    /*
     * @description: 获取到登录用户的菜单权限
     * @param userName
     * @return: java.util.List<com.murphy.gee.sys.entity.Menu>
     * @author: Murphy.Gee
     * @date: 2019-08-09 15:14
     */
    List<Menu> findMenuByUserName(String userName);
    /*
     * @description: 获取到登录用户的菜单权限
     * @param modulesId
     * @return: java.util.List<com.murphy.gee.sys.entity.Menu>
     * @author: Murphy.Gee
     * @date: 2019-08-27 11:08
     */
    List<Menu> findMenuByModulesId(Long modulesId);
}