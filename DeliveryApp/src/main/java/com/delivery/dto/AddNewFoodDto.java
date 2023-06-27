package com.delivery.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

public class AddNewFoodDto {
	
	private int foodId;

	
	public int getFoodId() {
		return foodId;
	}


	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@NotEmpty
	private String name;
}
