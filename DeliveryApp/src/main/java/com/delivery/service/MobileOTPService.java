package com.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.dto.MobileOtpSendDto;
import com.delivery.dto.MobileOtpValidateDto;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class MobileOTPService {
	
	@Autowired
	OTPProcess otpProcess;

	private final String ACCOUNT_SID = "AC7fdece807cdca1cc1e179d736d335343";

	private final String AUTH_TOKEN = "2fd7827cb283f103080fc04a6b69ee08";

	private final String FROM_NUMBER = "+15075754970";

	public void send(MobileOtpSendDto otpSend) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message message = Message.creator(new PhoneNumber(otpSend.getPhoneNumber()), new PhoneNumber(FROM_NUMBER),
				otpProcess.generateOTP(otpSend.getPhoneNumber())).create();
	}

	public Boolean otpValidater(MobileOtpValidateDto otpValidate) {

		String validOTP = otpProcess.getOPTByKey(otpValidate.getKey());

		if ((validOTP != null) && (validOTP.equals(otpValidate.getOtp()))) {
			return true;
		}

		return false;

	}

}
