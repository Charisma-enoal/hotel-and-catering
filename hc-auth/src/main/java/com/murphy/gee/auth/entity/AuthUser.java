package com.murphy.gee.auth.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * @ClassName AuthUser
 * @Description 认证用户实体
 * @Author Murphy.Gee
 * @Date 2019-07-22 15:35
 * @Version 1.0
 **/
@Data
public class AuthUser implements UserDetails, Serializable {
    private Collection<GrantedAuthority> authorities;//权限的集合
    private String username; //用户名
    private String password; //密码
    private boolean accountNonExpired; //是否过期
    private boolean accountNonLocked; //是否锁定
    private boolean credentialsNonExpired; //证书是否过期
    private boolean enabled; //是否禁用
}
