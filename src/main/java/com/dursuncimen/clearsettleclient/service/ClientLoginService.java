package com.dursuncimen.clearsettleclient.service;

import java.util.Optional;
import java.util.concurrent.Future;

import com.dursuncimen.clearsettleclient.model.Identification;
import com.dursuncimen.clearsettleclient.model.IdentificationResponse;

public interface ClientLoginService {
	
	public Future<Optional<IdentificationResponse>> login(Identification identification);
	
}
