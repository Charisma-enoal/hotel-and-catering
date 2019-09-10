package com.murphy.gee.auth.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sys_user")
public class SysUser  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id",nullable = false)
	private Long userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_real_name")
	private String userRealName;

	@Column(name = "user_password")
	private String userPassword;

	@Column(name = "user_enable")
	private Long userEnable;

	@Column(name = "create_date")
	private java.util.Date createDate;

	@Column(name = "create_person")
	private String createPerson;

	@Column(name = "last_edit_date")
	private java.util.Date lastEditDate;

	@Column(name = "last_edit_person")
	private String lastEditPerson;

}
