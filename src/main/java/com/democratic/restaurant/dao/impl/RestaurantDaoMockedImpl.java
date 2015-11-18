package com.democratic.restaurant.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.democratic.restaurant.dao.RestaurantDao;
import com.democratic.restaurant.model.Restaurant;

/**
 * @author Ricardo Machado
 *
 */
@Repository
public class RestaurantDaoMockedImpl implements RestaurantDao{

	/* (non-Javadoc)
	 * @see com.democratic.restaurant.dao.RestaurantDao#list()
	 */
	@Override
	public List<Restaurant> list() {
		return gererateRestaurants();
	}
	
	/**
	 * @return
	 */
	private List<Restaurant> gererateRestaurants(){
		
		List<Restaurant> restaurants = new ArrayList<>();
		
		restaurants.add(new Restaurant("Rica Pancita"));
		restaurants.add(new Restaurant("Bom de Prato"));
		restaurants.add(new Restaurant("Casarão"));
		restaurants.add(new Restaurant("Panquecas da vovó"));
		restaurants.add(new Restaurant("Xis do Gordo"));
		
		return restaurants;
	}
}
