package com.vasanth.microservices.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vasanth.microservices.customer.entity.Customer;
import com.vasanth.microservices.customer.repo.CustomerRepository;
import com.vasanth.microservices.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repo;

	@Override
	public List<Customer> getCustomerByRestaurantId(Integer id) {

		return repo.findByRestaurantId(id);

	}

	@Override
	public Customer addCustomer(Customer customer) {
		return repo.save(customer);
	}

}
