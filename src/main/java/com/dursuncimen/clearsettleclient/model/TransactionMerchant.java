package com.dursuncimen.clearsettleclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionMerchant {
	private Merchant merchant;

	public TransactionMerchant() {
		// TODO Auto-generated constructor stub
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	@Override
	public String toString() {
		return "TransactionMerchant [merchant=" + merchant + "]";
	}

}
