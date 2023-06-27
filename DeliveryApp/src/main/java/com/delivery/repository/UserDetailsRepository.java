package com.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.model.CustomerDetailsPojo;

public interface UserDetailsRepository extends JpaRepository<CustomerDetailsPojo, Integer> {

	CustomerDetailsPojo save(CustomerDetailsPojo customerDetailsPojo);

}
