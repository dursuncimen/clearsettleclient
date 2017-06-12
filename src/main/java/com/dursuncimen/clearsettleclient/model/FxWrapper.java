package com.dursuncimen.clearsettleclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FxWrapper {
	private Fx merchant;

	public FxWrapper() {
		// TODO Auto-generated constructor stub
	}

	public Fx getMerchant() {
		return merchant;
	}

	public void setMerchant(Fx merchant) {
		this.merchant = merchant;
	}

	@Override
	public String toString() {
		return "TransactionFx [merchant=" + merchant + "]";
	}

}
