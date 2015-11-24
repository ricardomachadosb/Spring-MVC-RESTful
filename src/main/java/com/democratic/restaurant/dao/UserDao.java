package com.democratic.restaurant.dao;

import java.util.List;

import com.democratic.restaurant.model.Restaurant;

/**
 * @author Ricardo Machado
 *
 */
public interface UserDao {

	public List<String> getUsersWhoVoted();
	
	public void addUserWhoVoted(String userName);
	
	public void clearCurrentVoteData();
	
}
