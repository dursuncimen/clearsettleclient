package com.dursuncimen.clearsettleclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionResponse {
	
	private MerchantWrapper transaction;
	
	private FxWrapper fx;
	
	private CustomerInfo customerInfo;
	
	private Merchant merchant;
	
	public TransactionResponse() {
		// TODO Auto-generated constructor stub
	}

	public MerchantWrapper getTransaction() {
		return transaction;
	}

	public void setTransaction(MerchantWrapper transaction) {
		this.transaction = transaction;
	}

	public FxWrapper getFx() {
		return fx;
	}

	public void setFx(FxWrapper fx) {
		this.fx = fx;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	@Override
	public String toString() {
		return "TransactionResponse [transaction=" + transaction + ", fx=" + fx + ", customerInfo=" + customerInfo
				+ ", merchant=" + merchant + "]";
	}
	
	
}
