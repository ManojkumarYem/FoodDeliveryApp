package com.delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.model.OrderableFoods;

public interface AvailableFoodRepository  extends JpaRepository<OrderableFoods, Integer>{

	List findByhotelId(int id);

}