package com.codelabs.exception;

import java.util.Set;

public class ValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private Set<String> errorCodes;
	
	public ValidationException(String message, Set<String> errorCodes) {
		this.message = message;
		this.errorCodes = errorCodes;
	}
	public String getMessage() {
		return message;
	}
	public Set<String> getErrorCodes() {
		return errorCodes;
	}
}
