package com.vasanth.microservices.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vasanth.microservices.customer.entity.Customer;
import com.vasanth.microservices.customer.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;

	@RequestMapping("/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("Hello Spring", HttpStatus.OK);
	}

	@RequestMapping("/id/{id}")
	public ResponseEntity<List<Customer>> getById(@PathVariable Integer id) {
		return new ResponseEntity<List<Customer>>(service.getCustomerByRestaurantId(id),HttpStatus.OK);

	}
	
	@PostMapping("add")
	public ResponseEntity<Customer> add(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(service.addCustomer(customer),HttpStatus.CREATED);

	}

}
