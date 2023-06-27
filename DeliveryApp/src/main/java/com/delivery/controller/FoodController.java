package com.delivery.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.delivery.dto.AddNewFoodDto;
import com.delivery.dto.ApiResponse;
import com.delivery.model.OrderableFoods;
import com.delivery.service.FoodService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin
public class FoodController {

	@Autowired
	FoodService foodService;

	@GetMapping("/GetAllAvailableFoods")
	public List<OrderableFoods> getAllAvailableFoods() {
		ApiResponse response = new ApiResponse();
		List<OrderableFoods> allFoods = foodService.getAllFoods();
		return allFoods;

	}
	
	@GetMapping("/getOneHotelItems")
	public List getOneHotelItems(@RequestParam("hotelId") int id) {
	System.out.println("gjgj");
//		get One Hotel's Food
		return foodService.getOneHotelItems(id);
		
	}
	
	
	

	@PostMapping("/addNewFoods")
	public ApiResponse addNewHotel(@RequestBody @Valid AddNewFoodDto addNewFoodDto) {
		ApiResponse response = new ApiResponse();
		foodService.addNewFoods(addNewFoodDto);
		response.setData("FOOD ADDED SUCESSFULLY");
		return response;
	}

}
