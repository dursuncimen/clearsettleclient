package com.dursuncimen.clearsettleclient.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Agent {
 
	private int id;
	
	private String customerIp;
	
	private String customerUserAgent;
	
	private String merchantIp;
	
	private String merchantUserAgent;
	
	@JsonProperty("created_at")
	private Date createdAt;
	
	@JsonProperty("updated_at")
	private Date updatedAt;
	
	@JsonProperty("deleted_at")
	private Date deletedAt;
	
	public Agent() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerIp() {
		return customerIp;
	}

	public void setCustomerIp(String customerIp) {
		this.customerIp = customerIp;
	}

	public String getCustomerUserAgent() {
		return customerUserAgent;
	}

	public void setCustomerUserAgent(String customerUserAgent) {
		this.customerUserAgent = customerUserAgent;
	}

	public String getMerchantIp() {
		return merchantIp;
	}

	public void setMerchantIp(String merchantIp) {
		this.merchantIp = merchantIp;
	}

	public String getMerchantUserAgent() {
		return merchantUserAgent;
	}

	public void setMerchantUserAgent(String merchantUserAgent) {
		this.merchantUserAgent = merchantUserAgent;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", customerIp=" + customerIp + ", customerUserAgent=" + customerUserAgent
				+ ", merchantIp=" + merchantIp + ", merchantUserAgent=" + merchantUserAgent + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
	}
	
	
}
