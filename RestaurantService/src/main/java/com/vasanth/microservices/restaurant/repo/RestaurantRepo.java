package com.vasanth.microservices.restaurant.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vasanth.microservices.restaurant.entity.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {

}
