package com.democratic.restaurant.dao;

import java.util.List;

import com.democratic.restaurant.model.Restaurant;

/**
 * @author Ricardo Machado
 *
 */
public interface RestaurantDao {

	public List<Restaurant> list();
	
	public Restaurant get(Integer id);
	
	public void vote(Restaurant restaurant);
	
	public void clearCurrentVoteData();
	
	public void clearWeekWinnersHistory();
	
	public List<Restaurant> getWeekWinners();
	
}
