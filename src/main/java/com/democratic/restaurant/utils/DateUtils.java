package com.democratic.restaurant.utils;

import java.util.Calendar;

/**
 * @author Ricardo Machado
 *
 */
public class DateUtils {
	
	/**
	 * @return
	 */
	public static boolean isSunday(){
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
	}
}
