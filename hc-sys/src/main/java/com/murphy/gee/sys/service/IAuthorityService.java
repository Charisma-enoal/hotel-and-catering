package com.murphy.gee.sys.service;

import com.murphy.gee.sys.entity.Authority;

import java.util.List;

public interface IAuthorityService {
    /*
     * @description: 根据用户名获取到用户的所有权限
     * @param userName
     * @return: java.util.List<com.murphy.gee.sys.entity.Authority>
     * @author: Murphy.Gee
     * @date: 2019-08-07 17:47
     */
    List<Authority> selectAuthByUsername(String userName);
}
