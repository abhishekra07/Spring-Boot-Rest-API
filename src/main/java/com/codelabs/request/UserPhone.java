package com.codelabs.request;

import javax.validation.constraints.NotEmpty;

import com.codelabs.utility.ErrorConstants;

public class UserPhone {
	private Long key;
	
	@NotEmpty(message = ErrorConstants.INVALID_PHONE_TYPE)
	private String type;
	
	@NotEmpty(message = ErrorConstants.INVALID_PHONE_NUMBER)
	private String number;
	
	private boolean primary;

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
}
