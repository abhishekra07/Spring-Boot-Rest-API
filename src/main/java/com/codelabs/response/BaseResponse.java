package com.codelabs.response;

import java.util.List;

public class BaseResponse {
	List<Error> errors;

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
}
