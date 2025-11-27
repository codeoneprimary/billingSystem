package com.billing.system.dto;

import java.time.LocalDateTime;

public class ApiResponseDto<T> {
	private boolean success;
	private String message;
	private T data;
	private LocalDateTime timestamp;

	public ApiResponseDto(boolean success, String message, T data) {
		this.success = success;
		this.message = message;
		this.data = data;
		this.timestamp = LocalDateTime.now();
	}

	public static <T> ApiResponseDto<T> success(String message, T data) {
		return new ApiResponseDto<>(true, message, data);
	}

	public static <T> ApiResponseDto<T> error(String message, T data) {
		return new ApiResponseDto<>(false, message, data);
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}
