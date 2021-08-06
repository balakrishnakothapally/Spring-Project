package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usertab")
public class WhUserType {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer userId;
	@Column(name="type")
	private String userType;
	@Column(name="code")
	private String userCode;
	@Column(name="ufor")
	private String userFor;
	@Column(name="gmail")
	private String userGmail;
	@Column(name="contact")
	private String userContact;
	@Column(name="idtype")
	private String userIdType;
	@Column(name="idnum")
	private String userIdNumber;
	public WhUserType() {
		super();
	}
	public WhUserType(Integer userId) {
		super();
		this.userId = userId;
	}
	public WhUserType(Integer userId, String userType, String userCode, String userFor, String userGmail,
			String userContact, String userIdType, String userIdNumber) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.userCode = userCode;
		this.userFor = userFor;
		this.userGmail = userGmail;
		this.userContact = userContact;
		this.userIdType = userIdType;
		this.userIdNumber = userIdNumber;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserFor() {
		return userFor;
	}
	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}
	public String getUserGmail() {
		return userGmail;
	}
	public void setUserGmail(String userGmail) {
		this.userGmail = userGmail;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getUserIdType() {
		return userIdType;
	}
	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}
	public String getUserIdNumber() {
		return userIdNumber;
	}
	public void setUserIdNumber(String userIdNumber) {
		this.userIdNumber = userIdNumber;
	}
	@Override
	public String toString() {
		return "WhUserType [userId=" + userId + ", userType=" + userType + ", userCode=" + userCode + ", userFor="
				+ userFor + ", userGmail=" + userGmail + ", userContact=" + userContact + ", userIdType=" + userIdType
				+ ", userIdNumber=" + userIdNumber + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
