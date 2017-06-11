package com.dursuncimen.clearsettleclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FxMerchant {

	private String originalCurrency;

	private int originalAmount;
	
	private String convertedCurrency;
	
	private int convertedAmount;
	

	public String getOriginalCurrency() {
		return originalCurrency;
	}

	public void setOriginalCurrency(String originalCurrency) {
		this.originalCurrency = originalCurrency;
	}

	public int getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(int originalAmount) {
		this.originalAmount = originalAmount;
	}

	public String getConvertedCurrency() {
		return convertedCurrency;
	}

	public void setConvertedCurrency(String convertedCurrency) {
		this.convertedCurrency = convertedCurrency;
	}

	public int getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(int convertedAmount) {
		this.convertedAmount = convertedAmount;
	}

	@Override
	public String toString() {
		return "TransactionFxMerchant [originalCurrency=" + originalCurrency + ", originalAmount=" + originalAmount
				+ ", convertedCurrency=" + convertedCurrency + ", convertedAmount=" + convertedAmount + "]";
	}

	
	

}
