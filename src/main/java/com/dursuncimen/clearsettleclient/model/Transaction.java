package com.dursuncimen.clearsettleclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {
	private FxMerchant merchant;

	public FxMerchant getMerchant() {
		return merchant;
	}

	public void setMerchant(FxMerchant merchant) {
		this.merchant = merchant;
	}

	@Override
	public String toString() {
		return "Transaction [merchant=" + merchant + "]";
	}
	
	
}
