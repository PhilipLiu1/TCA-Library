package com.tor.church.library.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Field;

public class Customer {
	
	@Id
	@Field(value="_id")
	private String id;

	@Field(value="firstName")
	@TextIndexed
	private String firstName;

	@Field(value="lastName")
	@TextIndexed
	private String lastName;

	@Field(value="otherName")
	@TextIndexed
	private String otherName;

	@Field(value="email")
	@TextIndexed
	private String email;

	@Field(value="cellPhone")
	@TextIndexed
	private String cellPhone;

	@Field(value="address")
	@TextIndexed
	private String address;

	@Field(value="homePhone")
	@TextIndexed
	private String homePhone;

	@Field(value="gender")
	@TextIndexed
	private String gender;

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
	public String getOtherName() {
		return otherName;
	}
	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
