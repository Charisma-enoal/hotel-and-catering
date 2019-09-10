package com.murphy.gee.sys.service;

import com.github.pagehelper.PageInfo;
import com.murphy.gee.sys.entity.User;

import java.security.Principal;


public interface IUserService {
    PageInfo<User> findList(Integer userEnable, String keyword, Integer pageNum, Integer pageSize);

    int save(User user, Principal principal);

    /*
     * @description: 加载用户信息
     * @param userName
     * @return: com.murphy.gee.sys.entity.User
     * @author: Murphy.Gee
     * @date: 2019-09-09 13:57
     */
    User initUser(String userName);
    /*
     * @description: 更改用户状态
     * @params: user
     * @return: int
     * @author: Murphy.Gee
     * @date: 2019-09-09 17:01
     */
    int modifyStatus(String userName,Integer userEnable,Principal principal);

    /*
     * @description: 重置密码
     * @param userName
     * @return: int
     * @author: Murphy.Gee
     * @date: 2019-09-09 17:50
     */
    int refreshPassword(String userName,Principal principal);

    /*
     * @description: 根据用户名删除用户
     * @param userId
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-09-10 9:47
     */
    void deleteByUserId(Integer userId);
}
