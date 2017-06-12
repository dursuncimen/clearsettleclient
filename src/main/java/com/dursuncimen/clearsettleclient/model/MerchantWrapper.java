package com.dursuncimen.clearsettleclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantWrapper {
	private Merchant merchant;
	
	public MerchantWrapper() {
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
		return "MerchantWrapper [merchant=" + merchant + "]";
	}
	
	
}
