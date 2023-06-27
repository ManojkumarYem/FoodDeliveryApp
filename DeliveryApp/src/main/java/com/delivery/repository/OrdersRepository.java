package com.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
