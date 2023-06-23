package com.vasanth.microservices.restaurant.service;

import java.util.List;

import com.vasanth.microservices.restaurant.entity.Customer;
import com.vasanth.microservices.restaurant.entity.Restaurant;

public interface RestaurantService {
	
	public Restaurant addRestaurant(Restaurant restaurant);

	public Restaurant getRestaurantById(Integer id);

	public List<Customer> getCustomersByRestaurantId(Integer id);

}
