package com.billing.system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.system.dto.ApiResponseDto;
import com.billing.system.dto.UserDto;
import com.billing.system.model.User;
import com.billing.system.services.UserOtpService;
import com.billing.system.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;

	private UserOtpService otpService;

	public UserController(UserService userService, UserOtpService otpService) {
		this.userService = userService;
		this.otpService = otpService;
	}

	@PostMapping
	public ResponseEntity<ApiResponseDto<User>> createUser(@RequestBody UserDto userDto) {

		User user = userService.userRegister(userDto);
		otpService.createUserOtp(user);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ApiResponseDto.success("User created successfully", user));
	}
}