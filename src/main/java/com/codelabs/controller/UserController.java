package com.codelabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codelabs.request.CreateUserRequest;
import com.codelabs.response.CreateSuccessResponse;
import com.codelabs.response.Response;
import com.codelabs.service.IUserService;
import com.codelabs.validator.RequestValidator;

@RestController
@RequestMapping("/api/users")
@Validated //required to enable javax validation
public class UserController {
	
	@Autowired
	RequestValidator validator;
	
	@Autowired
	IUserService userService;
	
	@GetMapping("/{userId}")
	public ResponseEntity<Response> getUser(@PathVariable Long userId) {
		return userService.getUser(userId);
	}
	
	@GetMapping
	public ResponseEntity<Response> getUsers() {
		return userService.getUsers();
	}
	
	@PostMapping
	public ResponseEntity<CreateSuccessResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {
		validator.validate(createUserRequest);
		return userService.createUser(createUserRequest);
	}
}