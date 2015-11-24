package com.democratic.restaurant.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.democratic.restaurant.dao.UserDao;

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
	
	@Override
	public void clearCurrentVoteData() {
		usersWhoVoted.clear();
	}
}
