package com.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

//import com.delivery.dto.MailOtpValidateDto;

@Service
public class MailOTPService {

	@Autowired
	private MailSender mailSender;

	@Autowired
	OTPProcess otp;

	public String sendSimpleMail(String to) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("yemmanoj4848@gmail.com");
		mailMessage.setTo(to);
		mailMessage.setText(otp.generateOTP(to));
		mailMessage.setSubject("OTP from EasyFood");
		mailSender.send(mailMessage);
		return "Mail Sent Successfully...";

	}
	
//	public Boolean otpValidaterforMailId(MailOtpValidateDto otpValidateDto) {
//
//		String validOTP = otp.getOPTByKey(otpValidateDto.getMailID());
//
//		if ((validOTP != null) && (validOTP.equals(otpValidateDto.getOtp()))) {
//			return true;
//		}
//
//		return false;
//
//	}

}
