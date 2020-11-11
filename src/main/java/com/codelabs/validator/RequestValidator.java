package com.codelabs.validator;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codelabs.exception.ValidationException;
import com.codelabs.utility.Constants;

@Component
public class RequestValidator {

	@Autowired
	Validator validator;
	
	public void validate(Object request) {
		Set<ConstraintViolation<Object>> violations = validator.validate(request);
		if(violations != null && violations.size() > 0) {
			Set<String> errors = new HashSet<>();
			violations.forEach( violation -> errors.add(violation.getMessage()));
			throw new ValidationException(Constants.VALIDATION_EXCEPTION_NAME,errors);
		}
		
	}
}
