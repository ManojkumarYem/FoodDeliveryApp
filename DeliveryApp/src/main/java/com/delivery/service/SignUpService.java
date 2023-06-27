package com.delivery.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.dto.SignUpDto;
import com.delivery.model.CustomerDetailsPojo;
import com.delivery.repository.UserDetailsRepository;

@Service
public class SignUpService {

	@Autowired
	UserDetailsRepository userRepo;

	public CustomerDetailsPojo signUp(SignUpDto signUpDto) {
		LocalDateTime currentDateAndTime = LocalDateTime.now();
		CustomerDetailsPojo customerDetailsPojo = new CustomerDetailsPojo();
		customerDetailsPojo.setName(signUpDto.getName());
		customerDetailsPojo.setPhoneNumber(signUpDto.getPhoneNumber());
		customerDetailsPojo.setLocation(signUpDto.getLocation());
		customerDetailsPojo.setCreatedAt(currentDateAndTime);
		return userRepo.save(customerDetailsPojo);
	}

//	public List getUserByMobileOrMail(String phone, String mail) {
//
//		return userRepo.findByphoneNumberOrMailId(phone, mail);
//
//	}

}
