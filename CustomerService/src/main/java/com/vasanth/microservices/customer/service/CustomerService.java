package com.vasanth.microservices.customer.service;

import java.util.List;

import com.vasanth.microservices.customer.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomerByRestaurantId(Integer id);

	public Customer addCustomer(Customer customer);

}