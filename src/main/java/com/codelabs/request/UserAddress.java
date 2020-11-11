package com.codelabs.request;

import javax.validation.constraints.NotEmpty;

import com.codelabs.utility.ErrorConstants;

public class UserAddress {

	private Long id;
	
	@NotEmpty(message = ErrorConstants.INVALID_ADDRESS_TYPE)
	private String type;
	
	@NotEmpty(message = ErrorConstants.INVALID_ADDRESS_LINE_1)
	private String addressLine1;

	private String addressLine2;
	
	@NotEmpty(message = ErrorConstants.INVALID_CITY)
	private String city;
	
	@NotEmpty(message = ErrorConstants.INVALID_STATE)
	private String state;
	
	@NotEmpty(message = ErrorConstants.INVALID_ZIP_CODE)
	private String zipCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
