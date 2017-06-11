package com.dursuncimen.clearsettleclient.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionQueryResponse {

	private int to;
	
	@JsonProperty("per_page")
	private int perPage;

	private List<Data> data;

	private int from;
	
	@JsonProperty("prev_page_url")
	private String prevPageUrl;
	
	@JsonProperty("next_page_url")
	private String nextPageUrl;
	
	@JsonProperty("current_page")
	private int currentPage;
	
	public TransactionQueryResponse() {
		// TODO Auto-generated constructor stub
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public String getPrevPageUrl() {
		return prevPageUrl;
	}

	public void setPrevPageUrl(String prevPageUrl) {
		this.prevPageUrl = prevPageUrl;
	}

	public String getNextPageUrl() {
		return nextPageUrl;
	}

	public void setNextPageUrl(String nextPageUrl) {
		this.nextPageUrl = nextPageUrl;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String toString() {
		return "TransactionResponse [to=" + to + ", perPage=" + perPage + ", data=" + data + ", from=" + from
				+ ", prevPageUrl=" + prevPageUrl + ", nextPageUrl=" + nextPageUrl + ", currentPage=" + currentPage
				+ "]";
	}
	
	
	
	
}
