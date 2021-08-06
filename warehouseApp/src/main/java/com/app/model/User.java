package com.app.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue
	@Column(name="uid")
	private Integer userId;
	@Column(name="un")
	private String userName;
	@Column(name="email")
	private String userEmail;
	@Column(name="pwd")
	private String userPwd;
	

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="user_roles_tab",joinColumns=@JoinColumn(name="uid"))
	@OrderColumn(name="pos")
	@Column(name="data")
	private Set<String> roles;

	public User() {
		super();
	}

	public User(Integer userId) {
		super();
		this.userId = userId;
	}

	public User(Integer userId, String userName, String userEmail, String userPwd, Set<String> roles) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPwd = userPwd;
		this.roles = roles;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPwd=" + userPwd
				+ ", roles=" + roles + "]";
	}
	

	
}
