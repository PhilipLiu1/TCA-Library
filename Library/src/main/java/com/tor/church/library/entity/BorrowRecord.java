package com.tor.church.library.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection="BRW_COL")
public class BorrowRecord {

	@Id
	@Field(value="_id")
	private String id;
	
	@Field(value="book")
	private BookItem book;

	@Field(value="client")
    private Client client;

	@Field(value="userId")
	private String userId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Field(value="startDate")
	private Date startDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Field(value="renewDate")
	private Date renewDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Field(value="returnDate")
	private Date returnDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Field(value="expectedReturnDate")
	private Date expectedReturnDate;

	@Field(value="renewTimes")
	private int renewTimes;

	@Field(value="returnedFlag")
	private Boolean returnedFlag;

	@Field(value="isExpired")
	private boolean isExpired;

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
	public int getRenewTimes() {
		return renewTimes;
	}
	public void setRenewTimes(int renewTimes) {
		this.renewTimes = renewTimes;
	}
	public Boolean getReturnedFlag() {
		return returnedFlag;
	}
	public void setReturnedFlag(Boolean returnedFlag) {
		this.returnedFlag = returnedFlag;
	}
	public boolean getIsExpired() {
		return isExpired;
	}
	public void setIsExpired(boolean isExpired) {
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
	public BookItem getBook() {
		return book;
	}
	public void setBook(BookItem book) {
		this.book = book;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}
	
}
