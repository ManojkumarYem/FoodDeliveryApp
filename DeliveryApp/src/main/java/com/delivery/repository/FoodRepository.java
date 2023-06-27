package com.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.model.AllFoods;
import com.delivery.model.OrderableFoods;

public interface FoodRepository  extends JpaRepository<AllFoods, Integer>{

}
