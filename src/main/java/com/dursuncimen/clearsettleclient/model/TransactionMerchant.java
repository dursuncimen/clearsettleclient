package com.dursuncimen.clearsettleclient.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionMerchant {

	private int id;

	private int agentInfoId;

	private String referenceNo;

	private int fxTransactionId;

	private String chainId;

	private String status;

	private String operation;

	private String returnUrl;

	private String transactionId;

	private String code;

	private Agent agent;

	private String message;
	
	private String merchantId;

	private int acquirerTransactionId;

	private String channel;
	
	private String customData;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("created_at")
	private Date createdAt;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("updated_at")
	private String updatedAt;


	public TransactionMerchant() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getAgentInfoId() {
		return agentInfoId;
	}


	public void setAgentInfoId(int agentInfoId) {
		this.agentInfoId = agentInfoId;
	}


	public String getReferenceNo() {
		return referenceNo;
	}


	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}


	public int getFxTransactionId() {
		return fxTransactionId;
	}


	public void setFxTransactionId(int fxTransactionId) {
		this.fxTransactionId = fxTransactionId;
	}


	public String getChainId() {
		return chainId;
	}


	public void setChainId(String chainId) {
		this.chainId = chainId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getOperation() {
		return operation;
	}


	public void setOperation(String operation) {
		this.operation = operation;
	}


	public String getReturnUrl() {
		return returnUrl;
	}


	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}


	public String getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Agent getAgent() {
		return agent;
	}


	public void setAgent(Agent agent) {
		this.agent = agent;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getMerchantId() {
		return merchantId;
	}


	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}


	public int getAcquirerTransactionId() {
		return acquirerTransactionId;
	}


	public void setAcquirerTransactionId(int acquirerTransactionId) {
		this.acquirerTransactionId = acquirerTransactionId;
	}


	public String getChannel() {
		return channel;
	}


	public void setChannel(String channel) {
		this.channel = channel;
	}


	public String getCustomData() {
		return customData;
	}


	public void setCustomData(String customData) {
		this.customData = customData;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public String getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}


	@Override
	public String toString() {
		return "TransactionMerchant [id=" + id + ", agentInfoId=" + agentInfoId + ", referenceNo=" + referenceNo
				+ ", fxTransactionId=" + fxTransactionId + ", chainId=" + chainId + ", status=" + status
				+ ", operation=" + operation + ", returnUrl=" + returnUrl + ", transactionId=" + transactionId
				+ ", code=" + code + ", agent=" + agent + ", message=" + message + ", merchantId=" + merchantId
				+ ", acquirerTransactionId=" + acquirerTransactionId + ", channel=" + channel + ", customData="
				+ customData + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	

}
