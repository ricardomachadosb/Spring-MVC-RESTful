package com.democratic.restaurant.exception;

/**
 * @author Ricardo Machado
 *
 */
public class RestaurantException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * @param message
	 */
	public RestaurantException(String message) {
		super(message);
	}
	
	/**
	 * @param message
	 */
	public RestaurantException(String message, Throwable t) {
		super(message, t);
	}
}
