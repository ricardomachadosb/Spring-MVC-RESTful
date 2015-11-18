package com.democratic.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	@RequestMapping(value = "/api/restaurant/list", method = RequestMethod.GET)
	public ResponseEntity<List<Restaurant>> listAllUsers() {
		
		List<Restaurant> restaurants = null;
		try {
			restaurants = restaurantService.list();
		}catch(Exception e){
			MultiValueMap<String, String> message = new LinkedMultiValueMap<String, String>();
			message.add("message", e.getMessage());
			return new ResponseEntity<List<Restaurant>>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (restaurants.isEmpty()) {
			return new ResponseEntity<List<Restaurant>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK);
	}
	 
	
}
