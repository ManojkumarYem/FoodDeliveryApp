package com.delivery.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class SignUpDto {

	@NotEmpty(message = "Name is Required")
	private String name;

	@Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$" ,message = "Mobile Number is not Valid")
	private String phoneNumber;

	@NotEmpty(message = "Location is Required")
	private String Location;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}
}
