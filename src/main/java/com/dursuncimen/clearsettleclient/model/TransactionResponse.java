package com.dursuncimen.clearsettleclient.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionResponse {
	
	private List<MerchantForTransaction> transaction;
	
	private List<Fx> fx;
	
	private List<CustomerInfo> customerInfo;
	
	private List<Merchant> merchant;
	
	public TransactionResponse() {
		// TODO Auto-generated constructor stub
	}

	public List<MerchantForTransaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<MerchantForTransaction> transaction) {
		this.transaction = transaction;
	}

	public List<Fx> getFx() {
		return fx;
	}

	public void setFx(List<Fx> fx) {
		this.fx = fx;
	}

	public List<CustomerInfo> getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(List<CustomerInfo> customerInfo) {
		this.customerInfo = customerInfo;
	}

	public List<Merchant> getMerchant() {
		return merchant;
	}

	public void setMerchant(List<Merchant> merchant) {
		this.merchant = merchant;
	}

	@Override
	public String toString() {
		return "TransactionResponse [transaction=" + transaction + ", fx=" + fx + ", customerInfo=" + customerInfo
				+ ", merchant=" + merchant + "]";
	}
	
	
}
