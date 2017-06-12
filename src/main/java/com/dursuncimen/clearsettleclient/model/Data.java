package com.dursuncimen.clearsettleclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
	private String refundable;
	
	
	@JsonProperty("updated_at")
	private String updatedAt;

	private TransactionWrapper transaction;

	private Merchant merchant;

	private FxWrapper fx;
	@JsonProperty("created_at")
	private String createdAt;

	private Acquirer acquirer;

	private Ipn ipn;

	private CustomerInfo customerInfo;
	
	public Data() {
		// TODO Auto-generated constructor stub
	}

	
	public String getRefundable() {
		return refundable;
	}


	public void setRefundable(String refundable) {
		this.refundable = refundable;
	}


	public String getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}


	public TransactionWrapper getTransaction() {
		return transaction;
	}


	public void setTransaction(TransactionWrapper transaction) {
		this.transaction = transaction;
	}


	public Merchant getMerchant() {
		return merchant;
	}


	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}


	public FxWrapper getFx() {
		return fx;
	}


	public void setFx(FxWrapper fx) {
		this.fx = fx;
	}


	public String getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


	public Acquirer getAcquirer() {
		return acquirer;
	}


	public void setAcquirer(Acquirer acquirer) {
		this.acquirer = acquirer;
	}


	public Ipn getIpn() {
		return ipn;
	}


	public void setIpn(Ipn ipn) {
		this.ipn = ipn;
	}


	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}


	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}


	@Override
	public String toString() {
		return "Data [refundable=" + refundable + ", updatedAt=" + updatedAt + ", transaction=" + transaction
				+ ", merchant=" + merchant + ", fx=" + fx + ", created_at=" + createdAt + ", acquirer=" + acquirer
				+ ", ipn=" + ipn + ", customerInfo=" + customerInfo + "]";
	}
	
	

}
