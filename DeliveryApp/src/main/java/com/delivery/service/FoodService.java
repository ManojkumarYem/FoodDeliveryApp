package com.delivery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.dto.AddNewFoodDto;
import com.delivery.model.AllDetails;
import com.delivery.model.AllFoods;
import com.delivery.model.OrderableFoods;
import com.delivery.repository.AvailableFoodRepository;
import com.delivery.repository.FoodRepository;
import com.delivery.repository.HotelRepository;

import jakarta.validation.Valid;

@Service
public class FoodService {
	@Autowired
	HotelRepository hotelRepo;
	@Autowired
	AvailableFoodRepository AvailablefoodRepo;
	@Autowired
	FoodRepository foodRepo;

	public List<OrderableFoods> getAllFoods() {

		return AvailablefoodRepo.findAll();
	}

	public List getOneHotelItems(int id) {

		List getItems = AvailablefoodRepo.findByhotelId(id);

		return getItems;

	}

	public void addNewFoods(AddNewFoodDto addNewFoodDto) {
		AllFoods foods = new AllFoods();
		foods.setFoodId(addNewFoodDto.getFoodId());
		foods.setName(addNewFoodDto.getName());
		foodRepo.save(foods);
	}

}
