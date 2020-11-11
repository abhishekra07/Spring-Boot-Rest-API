package com.codelabs.request;

import java.util.List;

import javax.validation.Valid;

import com.codelabs.model.Address;

public class User{
	
	@Valid
	private BasicDetails basicInfo;
	
	@Valid
	private List<UserAddress> addresses;
	
	@Valid
	private List<UserPhone> phones;

	public BasicDetails getBasicInfo() {
		return basicInfo;
	}

	public void setBasicInfo(BasicDetails basicInfo) {
		this.basicInfo = basicInfo;
	}

	public List<UserAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<UserAddress> addresses) {
		this.addresses = addresses;
	}

	public List<UserPhone> getPhones() {
		return phones;
	}

	public void setPhones(List<UserPhone> phones) {
		this.phones = phones;
	}
}
