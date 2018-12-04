package com.tor.church.library.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Field;

public class User {
	
	@Id
	@Field(value="_id")
	private String id;
	@Field(value="userName")
	@TextIndexed
	private String userName;
	@Field(value="password")
	@TextIndexed
	private String password;
	@Field(value="role")
	@TextIndexed
	private String role;
	@Field(value="firstName")
	@TextIndexed
	private String firstName;
	@Field(value="lastName")
	@TextIndexed
	private String lastName;
	@Field(value="cellPhone")
	@TextIndexed
	private String cellPhone;
	@Field(value="homePhone")
	@TextIndexed
	private String homePhone;
	@Field(value="email")
	@TextIndexed
	private String email;
	@Field(value="status")
	@TextIndexed
	private String status;
	@Field(value="memo")
	@TextIndexed
	private String memo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

}
