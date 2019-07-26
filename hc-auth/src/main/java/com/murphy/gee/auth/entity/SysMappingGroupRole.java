package com.murphy.gee.auth.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "sys_mapping_group_role")
public class SysMappingGroupRole  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mapping_id")
	private Long mappingId;

	@Column(name = "group_id")
	private Long groupId;

	@Column(name = "role_id")
	private Long roleId;

}
