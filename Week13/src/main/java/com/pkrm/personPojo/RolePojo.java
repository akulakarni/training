package com.pkrm.personPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RolePojo {
	@JsonProperty("roleId")
	private int roleId;
	@JsonProperty("roleName")
	private String roleName;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
