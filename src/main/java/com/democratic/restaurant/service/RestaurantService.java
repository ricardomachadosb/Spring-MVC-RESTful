package com.democratic.restaurant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.democratic.restaurant.dao.RestaurantDao;
import com.democratic.restaurant.datas.RestaurantData;
import com.democratic.restaurant.exception.RestaurantException;
import com.democratic.restaurant.model.Restaurant;

/**
 * @author Ricardo Machado
 *
 */
@Service
public class RestaurantService {
	
	@Autowired
	RestaurantDao restaurantDao;
	
	private String LIST_DEFAULT_ERROR_MESSAGE = "Problemas ao buscar restaurante cadastrado, tente novamente mais tarde";
	
	/**
	 * @return A list with all restaurants
	 */
	public List<RestaurantData> listDatas() throws RestaurantException{
		
		List<Restaurant> restaurants = null;
		List<RestaurantData> restaurantDatas = null;
		
		try {
			restaurants = restaurantDao.list();
			
			restaurants.removeAll(restaurantDao.getWeekWinners());
			
			restaurantDatas = buildRestaurantDatas(restaurants);
		}catch(Exception e){
			throw new RestaurantException(LIST_DEFAULT_ERROR_MESSAGE, e);
		}
		
		validateListResult(restaurantDatas);
		
		return restaurantDatas;
	}
	
	/**
	 * @param id
	 * @return
	 * @throws RestaurantException
	 */
	public Restaurant get(int id) throws RestaurantException{
		Restaurant restaurant = restaurantDao.get(id);
		if(restaurant == null){
			throw new RestaurantException("Restaurante não encontrado");
		}
		
		return restaurant;
	}
	
	/**
	 * @param restaurants
	 * @throws RestaurantException
	 */
	private void validateListResult(List<RestaurantData> restaurants ) throws RestaurantException{
		if(restaurants == null){
			throw new RestaurantException(LIST_DEFAULT_ERROR_MESSAGE);
		}
	}
	
	/**
	 * @param map
	 * @return
	 */
	public List<RestaurantData> buildRestaurantDatas(Map<Restaurant, Integer> map){
		List<RestaurantData> datas = new ArrayList<RestaurantData>();
		
		for(Map.Entry<Restaurant, Integer> entry: map.entrySet()){
			datas.add(0,new RestaurantData(entry.getKey(), entry.getValue()));
		}
		
		populateVotesPercent(datas);
		
		return datas;
	}
	
	/**
	 * @param datas
	 */
	private void populateVotesPercent(List<RestaurantData> datas){
		Integer totalVotes = 0;
		
		for(RestaurantData data: datas){
			totalVotes += data.getVotes();
		}
		
		for(RestaurantData data: datas){
			data.setVotesPercent((data.getVotes() * 100) / totalVotes);
		}
	}
	
	
	/**
	 * @param restaurants
	 * @return
	 */
	private List<RestaurantData> buildRestaurantDatas(List<Restaurant> restaurants){
		List<RestaurantData> datas = new ArrayList<RestaurantData>();
		
		for(Restaurant restaurant: restaurants){
			datas.add(new RestaurantData(restaurant));
		}
		
		return datas;
	}
}
