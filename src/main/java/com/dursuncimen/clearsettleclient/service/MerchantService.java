package com.dursuncimen.clearsettleclient.service;

import java.util.Optional;
import java.util.concurrent.Future;

import com.dursuncimen.clearsettleclient.model.Merchant;
import com.dursuncimen.clearsettleclient.model.TransactionPost;


public interface MerchantService {
	
	public Future<Optional<Merchant>> getMerchant(String token, TransactionPost  transactionPost);
		
}
