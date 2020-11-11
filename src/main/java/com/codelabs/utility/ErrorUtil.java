package com.codelabs.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.codelabs.response.Error;
import com.codelabs.startup.Startup;

@Named
public class ErrorUtil {
	
	@Autowired
	Startup startup;
	
	public Error getError(String errorCode) {
		Error error = new Error();
		error.setCode(errorCode);
		error.setMessage(startup.getApiErrorCodes().get(errorCode));
		return error;
	}
	
	public List<Error> getErrorList(Set<String> errorCodes){
		List<Error> errors = new ArrayList<>();
		if(!CollectionUtils.isEmpty(errorCodes)) {
			for(String errorCode: errorCodes) {
				errors.add(getError(errorCode));
			}
		}
		return errors;
	}
	
	public List<Error> getErrorList(String errorCode){
		List<Error> errors = new ArrayList<>();
		errors.add(getError(errorCode));
		return errors;
	}
}
