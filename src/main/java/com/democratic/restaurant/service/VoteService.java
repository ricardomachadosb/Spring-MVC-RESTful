package com.democratic.restaurant.service;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import com.democratic.restaurant.utils.DateUtils;
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
		
		if(votingIsClosed()){
			throw new RestaurantException("Votação encerrada");
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
		Restaurant restaurantWinner = getWinner();
		
		if(restaurantWinner != null){
			restaurantDao.addWeekWinner(restaurantWinner);
		}
		
		if(DateUtils.isSunday() || restaurantDao.getWeekWinners().size() >= 6){
			restaurantDao.clearWeekWinnersHistory();
		}
	}
	
	/**
	 * @return
	 */
	private Restaurant getWinner(){
		Restaurant winner = null;
		
		Map<Restaurant, Integer> result = restaurantDao.getResultMap();
		result = orderResultMapByVotes(result);
		if(existsValidWinner(result)){
			winner = result.entrySet().iterator().next().getKey();
		}
		
		return winner;
	}
	
	/**
	 * @param orderedResult
	 * @return
	 */
	private boolean existsValidWinner(Map<Restaurant, Integer> orderedResult){
		boolean isValid = false;
		
		if(orderedResult.size() == 1){
			return true;
		}else if(orderedResult.size() > 1){
			Iterator<Entry<Restaurant, Integer>> iterator = orderedResult.entrySet().iterator();
			isValid = iterator.next().getValue() > iterator.next().getValue();
		}
		
		return isValid;
	}
	
	/**
	 * @return
	 */
	public List<RestaurantData> getResultListData(){
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
    public boolean votingIsClosed(){
    	return votingStatus.equals(VotingStatusEnum.CLOSED);
    }
}
