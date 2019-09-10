package com.murphy.gee.auth.repository;

import com.murphy.gee.auth.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SysUser,Long> {
    SysUser findByUserName(String userName);
}
