package com.delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.model.AllHotels;

public interface HotelRepository  extends JpaRepository<AllHotels, Integer>{

	List findByhotelId(int id);

}
