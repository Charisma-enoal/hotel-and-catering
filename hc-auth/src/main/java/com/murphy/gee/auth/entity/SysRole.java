package com.murphy.gee.auth.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sys_role")
public class SysRole  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id",nullable = false)
	private Long roleId;

	@Column(name = "role_name")
	private String roleName;

	@Column(name = "role_enable")
	private Long roleEnable;

	@Column(name = "role_remark")
	private String roleRemark;

}
