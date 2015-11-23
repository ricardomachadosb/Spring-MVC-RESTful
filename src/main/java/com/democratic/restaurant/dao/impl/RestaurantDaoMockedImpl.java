package com.democratic.restaurant.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.democratic.restaurant.dao.RestaurantDao;
import com.democratic.restaurant.model.Restaurant;

/**
 * @author Ricardo Machado
 *
 */
@Repository
public class RestaurantDaoMockedImpl implements RestaurantDao{
	
	private static List<Restaurant> restaurantList = null;
	private static Map<Integer, Integer> votes = new HashMap<Integer, Integer>();

	/* (non-Javadoc)
	 * @see com.democratic.restaurant.dao.RestaurantDao#list()
	 */
	@Override
	public List<Restaurant> list() {
		
		if(restaurantList != null){
			return restaurantList;
		}
		
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
		
		for(int i = 0; i < restaurants.size(); i++){
			restaurants.get(i).setId(i);
		}
		
		restaurantList = restaurants;
		
		return restaurants;
	}
	
	/* (non-Javadoc)
	 * @see com.democratic.restaurant.dao.RestaurantDao#get(java.lang.Integer)
	 */
	@Override
	public Restaurant get(Integer id) {
		Restaurant restaurantToReturn = null;
		if(restaurantList == null){
			return restaurantToReturn;
		}
		
		for(Restaurant restaurant: restaurantList){
			if(id.equals(restaurant.getId())){
				restaurantToReturn = restaurant;
				break;
			}
		}
		
		return restaurantToReturn;
	}
	
	@Override
	public void vote(Restaurant restaurant) {
		if(votes.containsKey(restaurant.getId())){
			votes.put(restaurant.getId(), (votes.get(restaurant.getId())+1));
		}else {
			votes.put(restaurant.getId(), 1);
		}
	}
}
