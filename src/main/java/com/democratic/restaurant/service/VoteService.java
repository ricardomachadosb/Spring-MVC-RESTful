package com.democratic.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.democratic.restaurant.dao.RestaurantDao;
import com.democratic.restaurant.dao.UserDao;
import com.democratic.restaurant.enums.VotingStatusEnum;
import com.democratic.restaurant.exception.RestaurantException;
import com.democratic.restaurant.model.Restaurant;

/**
 * @author ramachado
 *
 */
@Service
public class VoteService {
	
	@Autowired
	RestaurantDao restaurantDao;
	
	@Autowired
	UserDao userDao;
	
	private static VotingStatusEnum votingStatus =  VotingStatusEnum.OPENED;
	
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
	 * 
	 */
	public void startNewVote(){
		restaurantDao.clearCurrentVoteData();
		userDao.clearCurrentVoteData();
		votingStatus = VotingStatusEnum.OPENED;
	}
	
	/**
	 * @return
	 */
	public static VotingStatusEnum getVotingStatus() {
		return votingStatus;
	}
}
