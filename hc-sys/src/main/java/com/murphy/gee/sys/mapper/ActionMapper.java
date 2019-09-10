package com.murphy.gee.sys.mapper;

import com.murphy.gee.sys.entity.Action;
import com.murphy.gee.sys.entity.ActionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActionMapper {
    long countByExample(ActionExample example);

    int deleteByExample(ActionExample example);

    int deleteByPrimaryKey(Long actionId);

    int insert(Action record);

    int insertSelective(Action record);

    List<Action> selectByExample(ActionExample example);

    Action selectByPrimaryKey(Long actionId);

    int updateByExampleSelective(@Param("record") Action record, @Param("example") ActionExample example);

    int updateByExample(@Param("record") Action record, @Param("example") ActionExample example);

    int updateByPrimaryKeySelective(Action record);

    int updateByPrimaryKey(Action record);
}