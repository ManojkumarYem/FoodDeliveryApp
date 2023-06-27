package com.delivery.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class MobileOtpSendDto {

	@NotEmpty(message = "Mobile Number is Required")
	@Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$",message = "Mobile Number is not Valid")
	private String phoneNumber;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
