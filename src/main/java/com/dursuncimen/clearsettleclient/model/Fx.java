package com.dursuncimen.clearsettleclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fx {
	private FxMerchant merchant;

	public Fx() {
		// TODO Auto-generated constructor stub
	}

	public FxMerchant getMerchant() {
		return merchant;
	}

	public void setMerchant(FxMerchant merchant) {
		this.merchant = merchant;
	}

	@Override
	public String toString() {
		return "TransactionFx [merchant=" + merchant + "]";
	}

}
