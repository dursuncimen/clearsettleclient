package com.dursuncimen.clearsettleclient.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = false)
public class TransactionPost {
	@NotBlank
	@Length(max=32)
	private String transactionId;
	
	public TransactionPost() {
		// TODO Auto-generated constructor stub
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		return "TransactionPost [transactionId=" + transactionId + "]";
	}
	
	
	
}
