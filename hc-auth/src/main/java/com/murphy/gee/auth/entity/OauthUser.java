package com.murphy.gee.auth.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "oauth_user")
public class OauthUser  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id",nullable = false)
	private Long userId;

	@Column(name = "last_edit_date")
	private java.util.Date lastEditDate;

	@Column(name = "last_edit_person")
	private String lastEditPerson;

	@Column(name = "user_create_date")
	private java.util.Date userCreateDate;

	@Column(name = "user_create_person")
	private String userCreatePerson;

	@Column(name = "user_enable")
	private Long userEnable;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_password")
	private String userPassword;

	@Column(name = "user_real_name")
	private String userRealName;

}
