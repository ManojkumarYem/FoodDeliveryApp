package com.delivery.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


public class MailOtpSendDto {
	

	@Email
	@NotEmpty
	private String mailId;

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

}
