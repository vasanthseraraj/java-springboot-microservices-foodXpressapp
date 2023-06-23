package com.vasanth.microservices.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vasanth.microservices.restaurant.entity.Customer;
import com.vasanth.microservices.restaurant.entity.Restaurant;
import com.vasanth.microservices.restaurant.repo.RestaurantRepo;
import com.vasanth.microservices.restaurant.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	public static final String CUSTOMER_SERVICE_URL = "http://CUSTOMER-SERVICE/api/customer";

	@Autowired
	private RestaurantRepo repo;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		return repo.save(restaurant);
	}

	@Override
	public Restaurant getRestaurantById(Integer id) {

		return repo.findById(id).get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomersByRestaurantId(Integer id) {
		System.out.println("Customer_Service Calling::::");
		return restTemplate.getForObject(CUSTOMER_SERVICE_URL + "/id/" + id, List.class);
	}

}
