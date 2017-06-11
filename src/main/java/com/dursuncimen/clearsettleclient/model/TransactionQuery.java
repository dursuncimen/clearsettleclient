package com.dursuncimen.clearsettleclient.model;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = false)
public class TransactionQuery {

	@DateTimeFormat(pattern="YYYY-MM-DD")
	private Date fromDate;

	@DateTimeFormat(pattern="YYYY-MM-DD")
	private Date toDate;
	
	@Length(max=64)
	private String status;
	
	@Length(max=64)
	private String operation;
	
	private int merchantId;
	
	private int acquirerId;
	
	@Length(max=32)
	private String paymentMethod;
	
	@Length(max=256)
	private String errorCode;
	
	@Length(max=128)
	private String filterField;
	
	@Length(max=256)
	private String filterValue;
	
	private int page;
	
	public TransactionQuery() {
		// TODO Auto-generated constructor stub
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public int getAcquirerId() {
		return acquirerId;
	}

	public void setAcquirerId(int acquirerId) {
		this.acquirerId = acquirerId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getFilterField() {
		return filterField;
	}

	public void setFilterField(String filterField) {
		this.filterField = filterField;
	}

	public String getFilterValue() {
		return filterValue;
	}

	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "TransactionQueryPost [fromDate=" + fromDate + ", toDate=" + toDate + ", status=" + status
				+ ", operation=" + operation + ", merchantId=" + merchantId + ", acquirerId=" + acquirerId
				+ ", paymentMethod=" + paymentMethod + ", errorCode=" + errorCode + ", filterField=" + filterField
				+ ", filterValue=" + filterValue + ", page=" + page + "]";
	}
	
	
	
}
