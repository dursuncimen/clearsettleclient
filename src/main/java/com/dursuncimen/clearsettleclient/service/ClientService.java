package com.dursuncimen.clearsettleclient.service;

import java.util.Optional;
import java.util.concurrent.Future;

import com.dursuncimen.clearsettleclient.model.CustomerInfoWrapper;
import com.dursuncimen.clearsettleclient.model.TransactionPost;


public interface ClientService {
	
	public Future<Optional<CustomerInfoWrapper>> getClient(String token, TransactionPost transactionPost);
	
}
