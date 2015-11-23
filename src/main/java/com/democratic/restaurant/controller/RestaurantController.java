package com.democratic.restaurant.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.democratic.restaurant.exception.RestaurantException;
import com.democratic.restaurant.model.Restaurant;
import com.democratic.restaurant.service.RestaurantService;

/**
 * @author Ricardo Machado
 *
 */
@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	/**
	 * @return
	 */
	@RequestMapping(value = "/api/restaurant/list", method = RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	public ResponseEntity<List<Restaurant>> listAllRestaurants() {
		
		List<Restaurant> restaurants = null;
		try {
			restaurants = restaurantService.list();
		}catch(Exception e){
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add("message", e.getMessage());
			return new ResponseEntity<List<Restaurant>>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		if (restaurants.isEmpty()) {
			return new ResponseEntity<List<Restaurant>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK);
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value = "/api/restaurant/vote/{id}", method = RequestMethod.PUT, produces={"application/json;charset=UTF-8"})
	public ResponseEntity<Restaurant> vote(@PathVariable Integer id) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		Restaurant restaurant = null;	
		
		try {
			restaurant = restaurantService.get(id);
			restaurantService.vote(restaurant);
			headers.add("message", "Você votou no restaurante " + restaurant.getName());
		}catch(RestaurantException e){
			headers.add("message", e.getMessage());
			return new ResponseEntity<Restaurant>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Restaurant>(headers, HttpStatus.OK);
	}
	 
	
}
