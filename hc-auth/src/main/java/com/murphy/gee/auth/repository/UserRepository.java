package com.murphy.gee.auth.repository;

import com.murphy.gee.auth.entity.OauthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<OauthUser,Long> {
    OauthUser findByUserName(String userName);
}
