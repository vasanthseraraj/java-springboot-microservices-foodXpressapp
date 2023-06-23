package com.vasanth.microservices.restaurant.dtos;

import java.util.List;

import com.vasanth.microservices.restaurant.entity.Customer;
import com.vasanth.microservices.restaurant.entity.Restaurant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodXpressDto {
	
	private Restaurant restaurant;
	private List<Customer> customers;
	

}
