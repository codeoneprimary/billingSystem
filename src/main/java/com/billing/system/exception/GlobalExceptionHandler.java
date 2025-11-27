package com.billing.system.exception;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.billing.system.dto.ApiResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponseDto<Object>> handleValidationException(MethodArgumentNotValidException ex) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));

		return ResponseEntity.badRequest().body(ApiResponseDto.error("Validation failed", errors));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponseDto<Object>> handleGeneralException(Exception ex) {

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ApiResponseDto.error("Something went wrong", null));
	}
}
