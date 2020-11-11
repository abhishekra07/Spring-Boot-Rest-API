package com.codelabs.startup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.codelabs.model.ApiErrorCodes;
import com.codelabs.repository.IApiErrorCodesRepository;

public class Startup {

	private Map<String,String> apiErrorCodes = new HashMap<>();
	
	@Autowired
	IApiErrorCodesRepository apiErrorRepo;
	
	public void init() {
		List<ApiErrorCodes> errorCodes = apiErrorRepo.findAll();
		errorCodes.forEach(error -> apiErrorCodes.put(error.getCode(), error.getDescription()));
	}
	
	public Map<String, String> getApiErrorCodes() {
		return apiErrorCodes;
	}



	public void destroy() {
		apiErrorCodes.clear();
	}
	
}
