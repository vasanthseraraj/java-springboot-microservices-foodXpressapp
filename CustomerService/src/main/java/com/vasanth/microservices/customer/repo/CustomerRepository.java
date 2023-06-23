package com.vasanth.microservices.customer.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vasanth.microservices.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public List<Customer> findByRestaurantId(Integer Id);

}
