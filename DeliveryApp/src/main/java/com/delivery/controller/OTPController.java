package com.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.dto.ApiResponse;
import com.delivery.dto.MailOtpSendDto;
//import com.delivery.dto.MailOtpValidateDto;
import com.delivery.dto.MobileOtpSendDto;
import com.delivery.dto.MobileOtpValidateDto;
import com.delivery.service.MailOTPService;
import com.delivery.service.MobileOTPService;
import com.delivery.service.SignUpService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
public class OTPController {

	@Autowired
	MobileOTPService mobileOtpService;

	@Autowired
	MailOTPService mailOtpService;

	@Autowired
	SignUpService signupService;
	/* api for otp send to mobile number */

	@PostMapping("/login/OTPsendToPhoneNumber")
	public ApiResponse OtpSend(@RequestBody MobileOtpSendDto otp) {
		ApiResponse response = new ApiResponse();
//		List data=signupService.getUserByMobileOrMail(null, otp.getPhoneNumber());
		mobileOtpService.send(otp);
		response.setData("OTP SENT Successfully");
//		response.setData(data);
		return response;
	}

	/* api for otp validate */

	@PostMapping("/login/OTPValidate")
	public ApiResponse validOtp(@RequestBody @Valid MobileOtpValidateDto otpValidateDto) {
		ApiResponse response = new ApiResponse();

		if (mobileOtpService.otpValidater(otpValidateDto) == true) {
			response.setData("OTP is VALID");
			return response;
		} else {
			response.setError("OTP is INVALID");
		}

		return response;
	}

	/* api for otp send to mailID */

	@PostMapping("/login/OTPsendToMailId")
	public String OtpSendToMail(@RequestBody @Valid MailOtpSendDto otp) {
		ApiResponse response = new ApiResponse();
		String mailId = otp.getMailId();
		mailOtpService.sendSimpleMail(mailId);
		response.setData("OTP SENT Successfully");
		return "Success";

	}

	/* api for MAIL otp validate */

//	@PostMapping("/login/MailOTPValidate")
//	public ApiResponse mailValidOtp(@RequestBody @Valid MailOtpValidateDto otpValidateDto) {
//		ApiResponse response = new ApiResponse();
//		if (mailOtpService.otpValidaterforMailId(otpValidateDto) == true) {
//			response.setData("OTP is VALID");
//			return response;
//		} else {
//			response.setData("OTP is INVALID");
//		}
//
//		return response;
//	}

}

///* api for otp send to mailID */
//@PostMapping("/login/OTPsendToMailId")
//public ApiResponse OtpSendToMail(@RequestParam("userName") String userName) {
//	ApiResponse response = new ApiResponse();
//	Pattern MailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
//	Matcher mailMatcher = MailPattern.matcher(userName);
//
//	 if (mailMatcher.matches()) {
//		mailOtpService.sendSimpleMail(userName);
//		response.setData("OTP SENT Successfully");
//	} else {
//		mobileOtpService.send(userName);
//		response.setData("OTP SENT Successfully");
//	}
//
//	return response;
//
//}
