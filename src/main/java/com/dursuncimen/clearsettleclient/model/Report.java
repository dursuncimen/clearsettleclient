package com.dursuncimen.clearsettleclient.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = false)
public class Report {
	
	@NotNull
	@DateTimeFormat(pattern="YYYY-MM-DD")
	private Date fromDate;
	
	@NotNull
	@DateTimeFormat(pattern="YYYY-MM-DD")
	private Date toDate;
	
	private int merchant;
	
	private int acquirer;
	
	public Report() {
		// TODO Auto-generated constructor stub
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public int getMerchant() {
		return merchant;
	}

	public void setMerchant(int merchant) {
		this.merchant = merchant;
	}

	public int getAcquirer() {
		return acquirer;
	}

	public void setAcquirer(int acquirer) {
		this.acquirer = acquirer;
	}

	@Override
	public String toString() {
		return "ReportPost [fromDate=" + fromDate + ", toDate=" + toDate + ", merchant=" + merchant + ", acquirer="
				+ acquirer + "]";
	}
	
	
}
