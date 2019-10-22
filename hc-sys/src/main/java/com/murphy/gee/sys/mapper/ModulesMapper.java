package com.murphy.gee.sys.mapper;

import com.murphy.gee.common.entity.AuthTreeSelect;
import com.murphy.gee.sys.entity.AuthListModel;
import com.murphy.gee.sys.entity.Modules;
import com.murphy.gee.sys.entity.ModulesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("modulesMapper")
public interface ModulesMapper {
    long countByExample(ModulesExample example);

    int deleteByExample(ModulesExample example);

    int deleteByPrimaryKey(Long modulesId);

    int insert(Modules record);

    int insertSelective(Modules record);

    List<Modules> selectByExample(ModulesExample example);

    Modules selectByPrimaryKey(Long modulesId);

    int updateByExampleSelective(@Param("record") Modules record, @Param("example") ModulesExample example);

    int updateByExample(@Param("record") Modules record, @Param("example") ModulesExample example);

    int updateByPrimaryKeySelective(Modules record);

    int updateByPrimaryKey(Modules record);

    /*
     * @description: 根据用户名查询该用户所拥有的模块权限
     * @param userName
     * @return: java.util.List<com.murphy.gee.sys.entity.Modules>
     * @author: Murphy.Gee
     * @date: 2019-08-09 14:50
     */
    List<Modules> findModulesByUserName(String userName);

    /*
     * @description: 查询到所有模块
     * @param
     * @return: java.util.List<com.murphy.gee.sys.entity.AuthListModel>
     * @author: Murphy.Gee
     * @date: 2019-09-12 12:14
     */
    List<AuthListModel> findAllModules();

    List<AuthTreeSelect> findAllModulesForAuth();
}