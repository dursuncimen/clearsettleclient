package com.dursuncimen.clearsettleclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionWrapper {
	private TransactionMerchant merchant;

	public TransactionMerchant getMerchant() {
		return merchant;
	}

	public void setMerchant(TransactionMerchant merchant) {
		this.merchant = merchant;
	}

	@Override
	public String toString() {
		return "Transaction [merchant=" + merchant + "]";
	}

}
