package com.dursuncimen.clearsettleclient.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
	private String refundable;
	
	@JsonProperty("updated_at")
	private String updatedAt;

	private List<Transaction> transaction;

	private List<Merchant> merchant;

	private List<Fx> fx;

	private String created_at;

	private Acquirer acquirer;

	private List<Ipn> ipn;

	private List<CustomerInfo> customerInfo;
	
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


	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public Acquirer getAcquirer() {
		return acquirer;
	}

	public void setAcquirer(Acquirer acquirer) {
		this.acquirer = acquirer;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	public List<Merchant> getMerchant() {
		return merchant;
	}

	public void setMerchant(List<Merchant> merchant) {
		this.merchant = merchant;
	}

	public List<Fx> getFx() {
		return fx;
	}

	public void setFx(List<Fx> fx) {
		this.fx = fx;
	}

	public List<Ipn> getIpn() {
		return ipn;
	}

	public void setIpn(List<Ipn> ipn) {
		this.ipn = ipn;
	}

	public List<CustomerInfo> getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(List<CustomerInfo> customerInfo) {
		this.customerInfo = customerInfo;
	}

	@Override
	public String toString() {
		return "Data [refundable=" + refundable + ", updatedAt=" + updatedAt + ", transaction=" + transaction
				+ ", merchant=" + merchant + ", fx=" + fx + ", created_at=" + created_at + ", acquirer=" + acquirer
				+ ", ipn=" + ipn + ", customerInfo=" + customerInfo + "]";
	}
	
	

}
