package com.democratic.restaurant.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.democratic.restaurant.model.Restaurant;
import com.democratic.restaurant.service.HelloWorldService;
import com.democratic.restaurant.service.RestaurantService;

@Controller
public class MainController {

	private final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private HelloWorldService helloWorldService;
	
	@Autowired
	private RestaurantService restaurantService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		logger.debug("index() is executed!");

		model.put("title", helloWorldService.getTitle(""));
		model.put("msg", helloWorldService.getDesc());
		
		List<Restaurant> restaurants = null;
		
		try {
			restaurants = restaurantService.list();
		}catch(Exception e){
			
		}
		
		model.put("restaurants", restaurants);
		
		return "index";
	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		logger.debug("hello() is executed - $name {}", name);

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		
		model.addObject("title", helloWorldService.getTitle(name));
		model.addObject("msg", helloWorldService.getDesc());
		
		return model;

	}

}