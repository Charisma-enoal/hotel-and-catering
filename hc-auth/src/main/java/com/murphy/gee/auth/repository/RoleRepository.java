package com.murphy.gee.auth.repository;

import com.murphy.gee.auth.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<SysRole,Long> {
    @Query(value = "    SELECT\n" +
            "    a.role_id, role_name, role_enable, role_remark\n" +
            "    FROM sys_role a LEFT JOIN sys_mapping_user_role b ON a.role_id = b.role_id\n" +
            "    LEFT JOIN sys_user c ON b.user_id = c.user_id\n" +
            "    WHERE c.user_name = ?1 AND a.role_enable = 1\n" +
            "    UNION\n" +
            "    SELECT\n" +
            "    role.role_id, role_name, role_enable, role_remark\n" +
            "    FROM sys_role role LEFT JOIN sys_mapping_group_role gr ON role.role_id = gr.role_id\n" +
            "    LEFT JOIN sys_user_group ugr ON gr.group_id = ugr.group_id\n" +
            "    LEFT JOIN sys_mapping_group_user smgu ON ugr.group_id = smgu.group_id\n" +
            "    LEFT JOIN sys_user su ON smgu.user_id = su.user_id\n" +
            "    WHERE su.user_name = ?1 AND role.role_enable = 1",nativeQuery = true)
    List<SysRole> findSysRoleByUserName(String userName);
}
