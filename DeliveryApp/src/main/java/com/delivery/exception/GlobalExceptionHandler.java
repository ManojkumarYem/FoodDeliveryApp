package com.delivery.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.delivery.dto.ApiResponse;
import com.twilio.exception.ApiException;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ApiResponse methodInvalidException(MethodArgumentNotValidException ex) {

		Map<String, String> errorMap = new HashMap<>();
		ApiResponse response = new ApiResponse();
	ex.getBindingResult().getFieldErrors().forEach(error->{
		errorMap.put(error.getField(),error.getDefaultMessage());
	});
		
		response.setError(errorMap);
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		return response;

	}
	
	@ExceptionHandler(value = ApiException.class)
	public ApiResponse APIException(ApiException ex) {
		ApiResponse response = new ApiResponse();
		response.setError(ex.getMessage());
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		return response;

	}

}
