package com.democratic.restaurant.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.democratic.restaurant.dao.RestaurantDao;
import com.democratic.restaurant.model.Restaunt;

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
	public List<Restaunt> list() {
		return gererateRestaurants();
	}
	
	/**
	 * @return
	 */
	private List<Restaunt> gererateRestaurants(){
		
		List<Restaunt> restaurants = new ArrayList<>();
		
		restaurants.add(new Restaunt("Rica Pancita"));
		restaurants.add(new Restaunt("Bom de Prato"));
		restaurants.add(new Restaunt("Casarão"));
		restaurants.add(new Restaunt("Panquecas da vovó"));
		restaurants.add(new Restaunt("Xis do Gordo"));
		
		return restaurants;
	}
}
