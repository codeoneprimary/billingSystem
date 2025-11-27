package com.billing.system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billing.system.dto.ApiResponseDto;
import com.billing.system.dto.UserOtpDto;
import com.billing.system.services.UserOtpService;

@RestController
@RequestMapping("/api/otp")
public class UserOtpController {

	private UserOtpService otpService;

	public UserOtpController(UserOtpService otpService) {
		this.otpService = otpService;
	}

	@PostMapping(name = "/verify")
	public ResponseEntity<ApiResponseDto<Boolean>> verifyOtp(@RequestBody UserOtpDto userotp) {

		boolean status = otpService.verifyUserOtp(userotp);

		return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponseDto.success("User otp verified", status));
	}
}
