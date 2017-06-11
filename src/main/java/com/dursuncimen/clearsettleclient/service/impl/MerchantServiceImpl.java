package com.dursuncimen.clearsettleclient.service.impl;

import java.util.Optional;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.dursuncimen.clearsettleclient.model.Merchant;
import com.dursuncimen.clearsettleclient.model.TransactionPost;
import com.dursuncimen.clearsettleclient.service.MerchantService;


@Service
public class MerchantServiceImpl implements MerchantService {

	private static final Logger log = LoggerFactory.getLogger(MerchantServiceImpl.class);

	@Value("${getMerchantUrl}")
	private String getMerchantUrl;

	@Autowired
	private RestTemplate restTemplate;

	@Async
	@Override
	public Future<Optional<Merchant>> getMerchant(String token,  TransactionPost transactionPost) {
		log.info("Post data: {} transactionPost: {} token: {}", transactionPost, getMerchantUrl, token);
		Merchant merchant = null;
		try {
			merchant = restTemplate.postForObject(getMerchantUrl, transactionPost, Merchant.class);
		} catch (HttpStatusCodeException e) {
			log.info("Post Error Http Code: {} Http Body: {}", e.getStatusCode(), e.getResponseBodyAsString());
		}
		return new AsyncResult<>(Optional.ofNullable(merchant));
	}

}
