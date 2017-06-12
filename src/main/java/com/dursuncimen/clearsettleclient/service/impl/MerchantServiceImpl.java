package com.dursuncimen.clearsettleclient.service.impl;

import java.util.Optional;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.dursuncimen.clearsettleclient.model.MerchantWrapper;
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
	public Future<Optional<MerchantWrapper>> getMerchant(String token,  TransactionPost transactionPost) {
		log.info("Post data: {} transactionPost: {} token: {}", transactionPost, getMerchantUrl, token);
		MerchantWrapper merchant = null;
		try {
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.set("Authorization", token);
	        HttpEntity<TransactionPost> httpEntity = new HttpEntity<>(transactionPost,httpHeaders);
			merchant = restTemplate.postForObject(getMerchantUrl, httpEntity,  MerchantWrapper.class);
		} catch (HttpStatusCodeException e) {
			log.info("Post Error Http Code: {} Http Body: {}", e.getStatusCode(), e.getResponseBodyAsString());
		}
		return new AsyncResult<>(Optional.ofNullable(merchant));
	}

}
