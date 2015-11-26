package com.democratic.restaurant.datas;

import com.democratic.restaurant.model.Restaurant;

/**
 * @author Ricardo Machado
 *
 */
public class RestaurantData {
	
	private int id;
	
	private String name;
	
	private Integer votes;
	
	private Integer votesPercent;
	
	public RestaurantData() {}
	
	public RestaurantData(Restaurant restaurant) {
		this.name = restaurant.getName();
		this.id = restaurant.getId();
	}
	
	public RestaurantData(Restaurant restaurant, Integer votes) {
		this(restaurant);
		this.votes = votes;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Integer getVotesPercent() {
		return votesPercent;
	}

	public void setVotesPercent(Integer votesPercent) {
		this.votesPercent = votesPercent;
	}
}
