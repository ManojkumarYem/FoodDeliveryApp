package com.delivery.controller;

import java.util.HashMap;

import java.util.Map;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.dto.ApiResponse;
import com.delivery.dto.SignUpDto;
import com.delivery.model.CustomerDetailsPojo;
import com.delivery.service.SignUpService;

import jakarta.validation.Valid;

@RestController
public class SignUpController {

	@Autowired
	SignUpService signupService;

	@PostMapping("/signUpUser")
	public ApiResponse signUp(@RequestBody @Valid SignUpDto signUpDto) {
		ApiResponse response = new ApiResponse();
		Map<String, Object> data = new HashMap();
		CustomerDetailsPojo customerDetailsPojo = signupService.signUp(signUpDto);

		if (customerDetailsPojo == null) {

			response.setError("Something Wrong when save data");
			response.setStatus(HttpStatus.SC_FAILED_DEPENDENCY);
			return response;
		}
		data.put("SaveStatus", "Saved Succesfully");
		data.put("Saved Data", customerDetailsPojo);
		response.setData(data);
		return response;

	}

}
