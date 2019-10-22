package com.murphy.gee.sys.mapper;

import com.murphy.gee.sys.entity.GroupRole;
import com.murphy.gee.sys.entity.GroupRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("groupRoleMapper")
public interface GroupRoleMapper {
    long countByExample(GroupRoleExample example);

    int deleteByExample(GroupRoleExample example);

    int deleteByPrimaryKey(Long mappingId);

    int insert(GroupRole record);

    int insertSelective(GroupRole record);

    List<GroupRole> selectByExample(GroupRoleExample example);

    GroupRole selectByPrimaryKey(Long mappingId);

    int updateByExampleSelective(@Param("record") GroupRole record, @Param("example") GroupRoleExample example);

    int updateByExample(@Param("record") GroupRole record, @Param("example") GroupRoleExample example);

    int updateByPrimaryKeySelective(GroupRole record);

    int updateByPrimaryKey(GroupRole record);

    List<Long> initDeptRoles(@Param("groupId") Long groupId);

    void insertBatch(List<GroupRole> list);

    Integer countByRoleId(Long roleId);
}