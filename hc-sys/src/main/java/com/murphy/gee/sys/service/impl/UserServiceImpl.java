package com.murphy.gee.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.murphy.gee.common.util.StringUtils;
import com.murphy.gee.sys.entity.*;
import com.murphy.gee.sys.mapper.UserGroupMapper;
import com.murphy.gee.sys.mapper.UserMapper;
import com.murphy.gee.sys.mapper.UserRoleMapper;
import com.murphy.gee.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description 用户管理实现类
 * @Author Murphy.Gee
 * @Date 2019-09-04 9:56
 * @Version 1.0
 **/
@Service("userService")
public class UserServiceImpl implements IUserService {

    private final String DEFAULT_PASSWORD = "666666";

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserGroupMapper userGroupMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    /*
     * @description: 用户列表查询
     * @param userEnable
     * @param keyword
     * @return: com.github.pagehelper.Page<com.murphy.gee.sys.entity.User>
     * @author: Murphy.Gee
     * @date: 2019-09-04 9:57
     */
    @Override
    public PageInfo<User> findList(Integer userEnable, String keyword,Integer pageNum,Integer pageSize) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (null != userEnable){
            criteria.andUserEnableEqualTo(userEnable);
        }
        if (StringUtils.isNotEmpty(keyword)){
            criteria.andUserNameOrUserRealName(keyword);
        }
        PageHelper.startPage(pageNum,pageSize);
        List<User> list = userMapper.selectByExample(example);
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        return pageInfo;
    }

    /*
     * @description: 保存用户
     * @param user
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-09-06 17:07
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public int save(User user, Principal principal) {
        user.setCreatePerson(principal.getName());
        user.setLastEditPerson(principal.getName());

        if (null != user.getUserId()){
            //修改用户
            int result = userMapper.updateByPrimaryKey(user);
            //修改用户所属部门
            UserGroup userGroup = new UserGroup();
            userGroup.setGroupId(user.getDeptId().longValue());
            userGroup.setUserId(user.getUserId());
            userGroupMapper.updateByUserId(userGroup);
            //修改用户所属角色
            //删除该用户的所有角色
            userRoleMapper.deleteRolesByUserId(user.getUserId().longValue());
            //批量插入角色
            batchList(user.getRoleIds(),user.getUserId().longValue());
            return result;
        }else{
            //新增用户
            user.setUserPassword(passwordEncoder.encode(DEFAULT_PASSWORD));
            int result = userMapper.insertReturnKey(user); //返回主键

            UserGroup userGroup = new UserGroup();
            userGroup.setUserId(user.getUserId().longValue());
            userGroup.setGroupId(user.getDeptId().longValue());
            userGroupMapper.insert(userGroup);//保存用户所属部门
            //批量插入角色
            batchList(user.getRoleIds(),user.getUserId().longValue());
            return result;
        }
    }
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public void batchList(String roleIdStr,Long userId){
        String[] roleIds = roleIdStr.split(",");
        List<UserRole> list = new ArrayList<UserRole>();
        for (String roleId : roleIds) {
            UserRole userRole = new UserRole();
            userRole.setUserId(userId.longValue());
            userRole.setRoleId(Long.parseLong(roleId));
            list.add(userRole);
        }
        userRoleMapper.insertBatch(list);
    }
    /*
     * @description: 加载用户信息
     * @param userName
     * @return: com.murphy.gee.sys.entity.User
     * @author: Murphy.Gee
     * @date: 2019-09-09 13:57
     */
    @Override
    public User initUser(String userName) {
        //根据用户名查询用户
        return userMapper.initUser(userName);
    }
    /*
     * @description: 更改用户状态
     * @param userName
     * @param userEnable
     * @return: int
     * @author: Murphy.Gee
     * @date: 2019-09-09 17:01
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public int modifyStatus(String userName, Integer userEnable,Principal principal) {
        User user = new User();
        user.setUserName(userName);
        user.setUserEnable(userEnable);
        user.setLastEditPerson(principal.getName());
        return userMapper.modifyStatus(user);
    }

    /*
     * @description: 重置密码
     * @param userName
     * @return: int
     * @author: Murphy.Gee
     * @date: 2019-09-09 17:50
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @Override
    public int refreshPassword(String userName,Principal principal) {
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(passwordEncoder.encode(DEFAULT_PASSWORD));
        user.setLastEditPerson(principal.getName());
        return userMapper.refreshPassword(user);
    }
    /*
     * @description: 根据用户名删除用户
     * @param userId
     * @return: void
     * @author: Murphy.Gee
     * @date: 2019-09-10 9:47
     */
    @Override
    public void deleteByUserId(Integer userId) {
        //删除用户
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(userId.longValue());
        userMapper.deleteByExample(userExample);
        //删除用户所属角色
        userRoleMapper.deleteRolesByUserId(userId.longValue());
        //删除用户与部门的映射关系
        UserGroupExample userGroupExample = new UserGroupExample();
        userGroupExample.createCriteria().andUserIdEqualTo(userId.longValue());
        userGroupMapper.deleteByExample(userGroupExample);
    }
}
