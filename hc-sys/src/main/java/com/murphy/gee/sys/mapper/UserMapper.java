package com.murphy.gee.sys.mapper;

import com.murphy.gee.sys.entity.User;
import com.murphy.gee.sys.entity.UserExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertReturnKey(User user);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findList(@Param("userEnable") Integer userEnable, @Param("keyword") String keyword);

    User initUser(String userName);

    int modifyStatus(User user);

    /*
     * @description: 重置密码
     * @param userName,userPassword
     * @return: int
     * @author: Murphy.Gee
     * @date: 2019-09-09 17:50
     */
    int refreshPassword(User user);
}