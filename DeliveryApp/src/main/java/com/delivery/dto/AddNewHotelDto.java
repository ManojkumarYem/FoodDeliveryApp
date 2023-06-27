package com.delivery.dto;

import jakarta.validation.constraints.NotEmpty;

public class AddNewHotelDto {
	
	private int hotelId;
	
	@NotEmpty(message = "HotelName Required")
	private String hotelName;
	
	@NotEmpty(message = "Location Required")
	private String location;

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
