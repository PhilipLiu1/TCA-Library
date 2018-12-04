package com.tor.church.library.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="BRW_COL")
public class BorrowRecord {

	@Id
	@Field(value="_id")
	private String id;
	
	@Field(value="itemId")
	private String itemId;

	@Field(value="customerId")
    private String customerId;

	@Field(value="userId")
	private String userId;

	@Field(value="startDate")
	private Date startDate;

	@Field(value="renewDate")
	private Date renewDate;

	@Field(value="returnDate")
	private Date returnDate;
	@Field(value="expectedReturnDate")
	private Date expectedReturnDate;

	@Field(value="renewTimes")
	private String renewTimes;

	@Field(value="returnedFlag")
	private Boolean returnedFlag;

	@Field(value="isExpired")
	private String isExpired;

	@Field(value="expiredReason")
	private String expiredReason;

	@Field(value="communication")
	private String communication;

	@Field(value="damagedFlag")
	private String damagedFlag;

	@Field(value="damageDesc")
	private String damageDesc;

	@Field(value="memo")
	private String memo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getRenewDate() {
		return renewDate;
	}
	public void setRenewDate(Date renewDate) {
		this.renewDate = renewDate;
	}
	public Date getExpectedReturnDate() {
		return expectedReturnDate;
	}
	public void setExpectedReturnDate(Date expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}
	public String getRenewTimes() {
		return renewTimes;
	}
	public void setRenewTimes(String renewTimes) {
		this.renewTimes = renewTimes;
	}
	public Boolean getReturnedFlag() {
		return returnedFlag;
	}
	public void setReturnedFlag(Boolean returnedFlag) {
		this.returnedFlag = returnedFlag;
	}
	public String getIsExpired() {
		return isExpired;
	}
	public void setIsExpired(String isExpired) {
		this.isExpired = isExpired;
	}
	public String getExpiredReason() {
		return expiredReason;
	}
	public void setExpiredReason(String expiredReason) {
		this.expiredReason = expiredReason;
	}
	public String getCommunication() {
		return communication;
	}
	public void setCommunication(String communication) {
		this.communication = communication;
	}
	public String getDamagedFlag() {
		return damagedFlag;
	}
	public void setDamagedFlag(String damagedFlag) {
		this.damagedFlag = damagedFlag;
	}
	public String getDamageDesc() {
		return damageDesc;
	}
	public void setDamageDesc(String damageDesc) {
		this.damageDesc = damageDesc;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
}