package com.dursuncimen.clearsettleclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerInfoWrapper {
	private CustomerInfo customerInfo;

	public CustomerInfoWrapper() {
		// TODO Auto-generated constructor stub
	}
	
    public CustomerInfo getCustomerInfo ()
    {
        return customerInfo;
    }

    public void setCustomerInfo (CustomerInfo customerInfo)
    {
        this.customerInfo = customerInfo;
    }

	@Override
	public String toString() {
		return "CustomerInfoWrapper [customerInfo=" + customerInfo + "]";
	}

    
}
