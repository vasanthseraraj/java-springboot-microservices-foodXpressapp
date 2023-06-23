package com.vasanth.microservices.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vasanth.microservices.restaurant.dtos.FoodXpressDto;
import com.vasanth.microservices.restaurant.entity.Customer;
import com.vasanth.microservices.restaurant.entity.Restaurant;
import com.vasanth.microservices.restaurant.service.RestaurantService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService service;

	@PostMapping("/add")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {

		return new ResponseEntity<Restaurant>(service.addRestaurant(restaurant), HttpStatus.CREATED);

	}

	@GetMapping("/id/{id}")
	@CircuitBreaker(name = "restaurantCircuitBreaker", fallbackMethod = "getAtleastRestaurantDetails")
	@Retry(name="restaurantRetryMechanism")
	public ResponseEntity<FoodXpressDto> getAllDetailsById(@PathVariable Integer id) {
		FoodXpressDto foodXpressDtoResponse = new FoodXpressDto();
		// Step: 1 --> getRestaurent based on Id
		Restaurant restaurant = service.getRestaurantById(id);
		foodXpressDtoResponse.setRestaurant(restaurant);

		// Step: 1 --> To get All customers based on restaurant id
		List<Customer> customers = service.getCustomersByRestaurantId(id);// calling CUSTOMER-SERVICE
		foodXpressDtoResponse.setCustomers(customers);

		return new ResponseEntity<>(foodXpressDtoResponse, HttpStatus.OK);

	}

	public ResponseEntity<FoodXpressDto> getAtleastRestaurantDetails(@PathVariable Integer id,Exception e) {

		
		System.out.println("FallBackMethod Calling::::");
		FoodXpressDto foodXpressDtoResponse = new FoodXpressDto();
		// Step: 1 --> getRestaurant based on Id
		Restaurant restaurant = service.getRestaurantById(id);
		foodXpressDtoResponse.setRestaurant(restaurant);
		return new ResponseEntity<>(foodXpressDtoResponse, HttpStatus.OK);
	}
}
