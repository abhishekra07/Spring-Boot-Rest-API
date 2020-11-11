package com.codelabs.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class CreateSuccessResponse extends BaseResponse{
	
	List<UserSuccessResponse> success;

	public List<UserSuccessResponse> getSuccess() {
		return success;
	}

	public void setSuccess(List<UserSuccessResponse> success) {
		this.success = success;
	}
}
