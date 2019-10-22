package com.murphy.gee.sys.mapper;

import com.murphy.gee.sys.entity.AuthorityAction;
import com.murphy.gee.sys.entity.AuthorityActionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("authorityActionMapper")
public interface AuthorityActionMapper {
    long countByExample(AuthorityActionExample example);

    int deleteByExample(AuthorityActionExample example);

    int deleteByPrimaryKey(Long mappingId);

    int insert(AuthorityAction record);

    int insertSelective(AuthorityAction record);

    List<AuthorityAction> selectByExample(AuthorityActionExample example);

    AuthorityAction selectByPrimaryKey(Long mappingId);

    int updateByExampleSelective(@Param("record") AuthorityAction record, @Param("example") AuthorityActionExample example);

    int updateByExample(@Param("record") AuthorityAction record, @Param("example") AuthorityActionExample example);

    int updateByPrimaryKeySelective(AuthorityAction record);

    int updateByPrimaryKey(AuthorityAction record);
}