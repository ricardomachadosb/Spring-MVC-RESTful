package com.democratic.restaurant.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.democratic.restaurant.dao.RestaurantDao;
import com.democratic.restaurant.dao.UserDao;
import com.democratic.restaurant.datas.RestaurantData;
import com.democratic.restaurant.enums.VotingStatusEnum;
import com.democratic.restaurant.exception.RestaurantException;
import com.democratic.restaurant.model.Restaurant;
import com.democratic.restaurant.utils.MapUtil;

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
	
	@Autowired
	RestaurantService restaurantService;
	
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
	 * 
	 */
	public void finishVoting(){
		votingStatus = VotingStatusEnum.CLOSED;
	}
	
	/**
	 * @return
	 */
	public List<RestaurantData> getResultList(){
		Map<Restaurant, Integer> result = restaurantDao.getResultMap();
		
		result = orderResultMapByVotes(result);
		return restaurantService.buildRestaurantDatas(result);
	}
	
	/**
	 * @param result
	 * @return
	 */
	private Map<Restaurant, Integer> orderResultMapByVotes(Map<Restaurant, Integer> result){
		Map<Restaurant, Integer> resultInOrder = MapUtil.sortByValue(result);
		return resultInOrder;
	}
	
	/**
	 * @return
	 */
	public static VotingStatusEnum getVotingStatus() {
		return votingStatus;
	}
	
	/**
	 * 
	 */
	public void clearWeekWinnersHistory(){
		restaurantDao.clearWeekWinnersHistory();
	}
	
    /**
     * @return
     */
    public boolean shouldDeleteWeekWinnersHistory(){
    	Calendar calendar = Calendar.getInstance();
    	int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    	return (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.MONDAY || restaurantDao.getWeekWinners().size() >= 6);
    }
}
