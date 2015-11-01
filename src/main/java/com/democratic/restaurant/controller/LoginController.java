package com.democratic.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Ricardo Machado
 *
 */
@Controller
public class LoginController {

	/**
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logout() {
		return "login";
	}
}