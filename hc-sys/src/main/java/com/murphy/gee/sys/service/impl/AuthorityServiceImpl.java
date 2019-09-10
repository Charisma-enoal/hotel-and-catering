package com.murphy.gee.sys.service.impl;

import com.murphy.gee.sys.entity.Authority;
import com.murphy.gee.sys.mapper.AuthorityMapper;
import com.murphy.gee.sys.service.IAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AuthorityServiceImpl
 * @Description 权限模块的实现类
 * @Author Murphy.Gee
 * @Date 2019-08-07 17:53
 * @Version 1.0
 **/
@Service("authorityService")
public class AuthorityServiceImpl implements IAuthorityService {
    @Autowired
    private AuthorityMapper authorityMapper;
    /*
     * @description: 根据用户名获取到用户的所有权限
     * @param userName
     * @return: java.util.List<com.murphy.gee.sys.entity.Authority>
     * @author: Murphy.Gee
     * @date: 2019-08-07 17:47
     */
    @Cacheable(value = "auth_info",key = "'auth_info_' + #userName")
    @Override
    public List<Authority> selectAuthByUsername(String userName) {
        return authorityMapper.selectAuthByUsername(userName);
    }
}
