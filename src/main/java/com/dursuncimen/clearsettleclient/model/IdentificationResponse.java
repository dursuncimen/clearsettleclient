package com.dursuncimen.clearsettleclient.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class IdentificationResponse {
		
	private String token;
	@Length(max=64)
	private String status;
	
	public IdentificationResponse() {
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserLoginResponse [token=" + token + ", status=" + status + "]";
	}	
	
}
