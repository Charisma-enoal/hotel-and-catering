package com.murphy.gee.auth.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sys_user_group")
public class SysUserGroup  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id")
	private Long groupId;

	@Column(name = "group_name")
	private String groupName;

	@Column(name = "group_parent_id")
	private Long groupParentId;

	@Column(name = "group_remark")
	private String groupRemark;

	@Column(name = "create_date")
	private java.util.Date createDate;

	@Column(name = "create_person")
	private String createPerson;

	@Column(name = "last_edit_date")
	private java.util.Date lastEditDate;

	@Column(name = "last_edit_person")
	private String lastEditPerson;

}
