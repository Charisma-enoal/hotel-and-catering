package com.murphy.gee.auth.service;

import com.murphy.gee.auth.entity.AuthUser;
import com.murphy.gee.auth.entity.OauthRole;
import com.murphy.gee.auth.entity.OauthUser;
import com.murphy.gee.auth.repository.RoleRepository;
import com.murphy.gee.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AuthUserDetailsService
 * @Description 用户服务
 * @Author Murphy.Gee
 * @Date 2019-07-22 15:32
 * @Version 1.0
 **/
@Service
public class AuthUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    /*
     * @description: 加载用户
     * @param s
     * @return: org.springframework.security.core.userdetails.UserDetails
     * @author: Murphy.Gee
     * @date: 2019-07-22 15:33
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //查询到用户
        OauthUser user = userRepository.findByUserName(s);
        AuthUser authUser = new AuthUser();
        if (null != user){
            authUser.setUsername(user.getUserName());
            authUser.setPassword(user.getUserPassword());
            authUser.setAccountNonExpired(user.getUserEnable() == 1 ? true : false);
            authUser.setAccountNonLocked(user.getUserEnable() == 1 ? true : false);
            authUser.setCredentialsNonExpired(user.getUserEnable() == 1 ? true : false);
            authUser.setEnabled(user.getUserEnable() == 1 ? true : false);
            //获取到用户所属角色
            List<OauthRole> roleList = roleRepository.findOauthRolesByUserName(s);
            if(null != roleList && roleList.size() > 0){
                List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
                for (OauthRole role : roleList) {
                    GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
                    list.add(authority);
                }
                authUser.setAuthorities(list);
            }
            return authUser;
        }else{
            throw new UsernameNotFoundException("当前用户不存在");
        }
    }
}
