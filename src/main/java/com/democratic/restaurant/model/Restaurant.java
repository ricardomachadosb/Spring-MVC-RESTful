package com.democratic.restaurant.model;

/**
 * @author Ricardo Machado
 *
 */
public class Restaurant {
	
	private String name;
	
	private int id;
	
	public Restaurant() {}
	
	public Restaurant(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
