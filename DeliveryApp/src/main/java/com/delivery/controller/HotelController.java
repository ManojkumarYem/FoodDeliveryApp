package com.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.dto.AddNewHotelDto;
import com.delivery.dto.ApiResponse;
import com.delivery.model.AllHotels;
import com.delivery.service.HotelService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	@GetMapping("/getHotels")
	public ApiResponse allHotels() {
		ApiResponse response =new ApiResponse();
		List<AllHotels> allHotels=hotelService.getAllHotels();
		response.setData(allHotels);
		return response;
		
	}
	
	@PostMapping("/addNewHotel")
	public ApiResponse addNewHotel(@RequestBody @Valid AddNewHotelDto addNewHotelDto) {
		ApiResponse response =new ApiResponse();	
		hotelService.addnewHotel(addNewHotelDto);
		response.setData("HOTEL ADDED SUCESSFULLY");
		return response;
	}
	
	
	@GetMapping("/getOneHotel")
	public List getOneHotel(@RequestParam("hotelId") int id) {
		
		
		return hotelService.getOneHotel(id);
		
	}
	

}
