package com.testing.model.security;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {
	@Id
	@GeneratedValue
	@Column(name = "user_role_id", 
		unique = true, nullable = false)
	private Integer userRoleId;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "username", nullable = false)
	private User user;
	@Column(name = "role", nullable = false, length = 45)
	private String role;
	
	public Integer getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
