package com.democratic.restaurant.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.democratic.restaurant.dao.RestaurantDao;
import com.democratic.restaurant.dao.UserDao;
import com.democratic.restaurant.model.Restaurant;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

/**
 * @author Ricardo Machado
 *
 */
@Repository
public class UserDaoMockedImpl implements UserDao{
	
	private static List<String> usersWhoVoted = new ArrayList<String>();

	@Override
	public List<String> getUsersWhoVoted() {
		return usersWhoVoted;
	}
	
	@Override
	public void addUserWhoVoted(String userName) {
		usersWhoVoted.add(userName);
	}
}
