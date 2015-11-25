package com.democratic.restaurant.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.democratic.restaurant.dao.RestaurantDao;
import com.democratic.restaurant.datas.RestaurantData;
import com.democratic.restaurant.exception.RestaurantException;
import com.democratic.restaurant.model.Restaurant;
import com.democratic.restaurant.service.RestaurantService;
import com.democratic.restaurant.service.VoteService;

/**
 * @author Ricardo Machado
 *
 */
@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private VoteService voteService;
	
	/**
	 * @return
	 */
	@RequestMapping(value = "/api/restaurant/list", method = RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	public ResponseEntity<List<RestaurantData>> listAllRestaurants() {
		
		List<RestaurantData> restaurants = null;
		try {
			restaurants = restaurantService.list();
		}catch(Exception e){
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add("message", e.getMessage());
			return new ResponseEntity<List<RestaurantData>>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		if (restaurants.isEmpty()) {
			return new ResponseEntity<List<RestaurantData>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RestaurantData>>(restaurants, HttpStatus.OK);
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value = "/api/restaurant/result", method = RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	public ResponseEntity<List<RestaurantData>> result() {
		
		List<RestaurantData> restaurants = null;
		try {
			restaurants = voteService.getResultList();
		}catch(Exception e){
			MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
			headers.add("message", e.getMessage());
			return new ResponseEntity<List<RestaurantData>>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (restaurants.isEmpty()) {
			return new ResponseEntity<List<RestaurantData>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<RestaurantData>>(restaurants, HttpStatus.OK);
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
			voteService.vote(restaurant);
			headers.add("message", "Você votou no restaurante " + restaurant.getName());
		}catch(RestaurantException e){
			headers.add("message", e.getMessage());
			return new ResponseEntity<Restaurant>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Restaurant>(headers, HttpStatus.OK);
	}
	 
	
}
