package com.dursuncimen.clearsettleclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AcquirerTransactions {
	
	private Acquirer acquirer;

    public Acquirer getAcquirer ()
    {
        return acquirer;
    }

    public void setAcquirer (Acquirer acquirer)
    {
        this.acquirer = acquirer;
    }
}
