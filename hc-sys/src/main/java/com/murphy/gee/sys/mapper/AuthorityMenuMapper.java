package com.murphy.gee.sys.mapper;

import com.murphy.gee.sys.entity.AuthorityMenu;
import com.murphy.gee.sys.entity.AuthorityMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthorityMenuMapper {
    long countByExample(AuthorityMenuExample example);

    int deleteByExample(AuthorityMenuExample example);

    int deleteByPrimaryKey(Long mappingId);

    int insert(AuthorityMenu record);

    int insertSelective(AuthorityMenu record);

    List<AuthorityMenu> selectByExample(AuthorityMenuExample example);

    AuthorityMenu selectByPrimaryKey(Long mappingId);

    int updateByExampleSelective(@Param("record") AuthorityMenu record, @Param("example") AuthorityMenuExample example);

    int updateByExample(@Param("record") AuthorityMenu record, @Param("example") AuthorityMenuExample example);

    int updateByPrimaryKeySelective(AuthorityMenu record);

    int updateByPrimaryKey(AuthorityMenu record);
}