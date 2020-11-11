package com.codelabs.service;

import org.springframework.http.ResponseEntity;

import com.codelabs.request.CreateUserRequest;
import com.codelabs.response.CreateSuccessResponse;
import com.codelabs.response.Response;

public interface IUserService {
	
	public ResponseEntity<Response> getUser(Long userId);
	
	public ResponseEntity<CreateSuccessResponse> createUser(CreateUserRequest createUserRequest);
	
	public ResponseEntity<Response> getUsers();
}
