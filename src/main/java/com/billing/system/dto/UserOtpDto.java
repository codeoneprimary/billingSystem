package com.billing.system.dto;

public class UserOtpDto {
	
	private Long regUserId;
	private String username;
	private String otp;

	public Long getRegUserId() {
		return regUserId;
	}

	public void setRegUserId(Long regUserId) {
		this.regUserId = regUserId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

}
