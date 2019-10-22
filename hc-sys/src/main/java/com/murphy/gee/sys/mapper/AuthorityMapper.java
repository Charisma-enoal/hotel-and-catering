package com.murphy.gee.sys.mapper;

import com.murphy.gee.sys.entity.Authority;
import com.murphy.gee.sys.entity.AuthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("authorityMapper")
public interface AuthorityMapper {
    long countByExample(AuthorityExample example);

    int deleteByExample(AuthorityExample example);

    int deleteByPrimaryKey(Long authId);

    int insert(Authority record);

    int insertSelective(Authority record);

    List<Authority> selectByExample(AuthorityExample example);

    Authority selectByPrimaryKey(Long authId);

    int updateByExampleSelective(@Param("record") Authority record, @Param("example") AuthorityExample example);

    int updateByExample(@Param("record") Authority record, @Param("example") AuthorityExample example);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);

    /*
     * @description: 根据用户名获取到用户的所有权限
     * @param userName
     * @return: java.util.List<com.murphy.gee.sys.entity.Authority>
     * @author: Murphy.Gee
     * @date: 2019-08-07 17:47
     */
    List<Authority> selectAuthByUsername(String userName);

}