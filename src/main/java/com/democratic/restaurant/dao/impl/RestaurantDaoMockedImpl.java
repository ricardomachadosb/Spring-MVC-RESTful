package com.democratic.restaurant.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
	private static List<Restaurant> weekWinners = new ArrayList<Restaurant>();

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
	
	@Override
	public void clearCurrentVoteData() {
		votes.clear();
	}

	@Override
	public void clearWeekWinnersHistory() {
		weekWinners.clear();
	}

	@Override
	public List<Restaurant> getWeekWinners() {
		return weekWinners;
	}

	@Override
	public Map<Restaurant, Integer> getResultMap() {
		Map<Restaurant, Integer> resultMap = new LinkedHashMap<Restaurant, Integer>();
		
		for(Map.Entry<Integer, Integer> entry: votes.entrySet()){
			resultMap.put(get(entry.getKey()), entry.getValue());
		}
		
		return resultMap;
	}

	@Override
	public void addWeekWinner(Restaurant restaurant) {
		weekWinners.add(restaurant);
	}
}
