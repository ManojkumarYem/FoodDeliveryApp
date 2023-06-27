package com.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.dto.AddNewHotelDto;
import com.delivery.model.AllHotels;
import com.delivery.repository.HotelRepository;

@Service
public class HotelService {
	
	
	@Autowired
	HotelRepository hotelRepo;
	
	public List<AllHotels> getAllHotels() {

		return hotelRepo.findAll();
		
	}

	public AllHotels addnewHotel(AddNewHotelDto addNewHotelDto) {
		AllHotels hotel=new AllHotels();
		hotel.setHotelId(addNewHotelDto.getHotelId());
		hotel.setHotelName(addNewHotelDto.getHotelName());
		hotel.setLocation(addNewHotelDto.getLocation());

		return hotelRepo.save(hotel);
	}

	public List getOneHotel(int id) {
		// TODO Auto-generated method stub
		return hotelRepo.findByhotelId(id);
	}
	

}
