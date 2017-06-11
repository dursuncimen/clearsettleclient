package com.dursuncimen.clearsettleclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Merchant {

	private int id;

	private int parentId;

	private String name;

	@JsonProperty("3dStatus")
	private String threeDStatus;
	
	private String mcc;
	
	private String ipnUrl;

	private String apiKey;

	private String cpgKey;

	private String type;

	private String descriptor;

	private String secretKey;
	
	private String comType;
	
	public Merchant() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThreeDStatus() {
		return threeDStatus;
	}

	public void setThreeDStatus(String threeDStatus) {
		this.threeDStatus = threeDStatus;
	}

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	public String getIpnUrl() {
		return ipnUrl;
	}

	public void setIpnUrl(String ipnUrl) {
		this.ipnUrl = ipnUrl;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getCpgKey() {
		return cpgKey;
	}

	public void setCpgKey(String cpgKey) {
		this.cpgKey = cpgKey;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getComType() {
		return comType;
	}

	public void setComType(String comType) {
		this.comType = comType;
	}

	@Override
	public String toString() {
		return "Merchant [id=" + id + ", parentId=" + parentId + ", name=" + name + ", threeDStatus=" + threeDStatus
				+ ", mcc=" + mcc + ", ipnUrl=" + ipnUrl + ", apiKey=" + apiKey + ", cpgKey=" + cpgKey + ", type=" + type
				+ ", descriptor=" + descriptor + ", secretKey=" + secretKey + ", comType=" + comType + "]";
	}
	
	

}
