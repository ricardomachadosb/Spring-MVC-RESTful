package com.democratic.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.democratic.restaurant.dao.RestaurantDao;
import com.democratic.restaurant.dao.UserDao;
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
	
	@Autowired
	UserDao userDao;
	
	private String LIST_DEFAULT_ERROR_MESSAGE = "Problemas ao buscar restaurante cadastrado, tente novamente mais tarde";
	
	/**
	 * @return A list with all restaurants
	 */
	public List<Restaurant> list() throws RestaurantException{
		
		List<Restaurant> restaurants = null;
		
		try {
			restaurants = restaurantDao.list();
		}catch(Exception e){
			throw new RestaurantException(LIST_DEFAULT_ERROR_MESSAGE, e);
		}
		
		validateListResult(restaurants);
		
		return restaurants;
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
	 * @param restaurant
	 * @throws RestaurantException
	 */
	public void vote(Restaurant restaurant) throws RestaurantException{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(userAlreadyVoted(auth.getName())){
			throw new RestaurantException("Você ja votou hoje");
		}
		
		restaurantDao.vote(restaurant);
		userDao.addUserWhoVoted(auth.getName());
	}
	
	/**
	 * @param userName
	 * @return
	 */
	private boolean userAlreadyVoted(String userName){
		return userDao.getUsersWhoVoted().contains(userName);
	}
	
	/**
	 * @param restaurants
	 * @throws RestaurantException
	 */
	private void validateListResult(List<Restaurant> restaurants ) throws RestaurantException{
		
		if(restaurants == null){
			throw new RestaurantException(LIST_DEFAULT_ERROR_MESSAGE);
		}
	}
	
}
