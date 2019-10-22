package com.murphy.gee.sys.mapper;

import com.murphy.gee.sys.entity.AuthorityModules;
import com.murphy.gee.sys.entity.AuthorityModulesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("authorityModulesMapper")
public interface AuthorityModulesMapper {
    long countByExample(AuthorityModulesExample example);

    int deleteByExample(AuthorityModulesExample example);

    int deleteByPrimaryKey(Long mappingId);

    int insert(AuthorityModules record);

    int insertSelective(AuthorityModules record);

    List<AuthorityModules> selectByExample(AuthorityModulesExample example);

    AuthorityModules selectByPrimaryKey(Long mappingId);

    int updateByExampleSelective(@Param("record") AuthorityModules record, @Param("example") AuthorityModulesExample example);

    int updateByExample(@Param("record") AuthorityModules record, @Param("example") AuthorityModulesExample example);

    int updateByPrimaryKeySelective(AuthorityModules record);

    int updateByPrimaryKey(AuthorityModules record);
}