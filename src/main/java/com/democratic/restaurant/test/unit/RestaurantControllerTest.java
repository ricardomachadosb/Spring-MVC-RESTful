package com.democratic.restaurant.test.unit;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.democratic.restaurant.config.SpringWebConfig;
import com.democratic.restaurant.controller.RestaurantController;
import com.democratic.restaurant.datas.RestaurantData;
import com.democratic.restaurant.model.Restaurant;
import com.democratic.restaurant.service.RestaurantService;
import com.democratic.restaurant.service.VoteService;

/**
 * @author Ricardo Machado
 *
 */
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {SpringWebConfig.class})
@WebAppConfiguration
public class RestaurantControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	RestaurantController restaurantController;
	
	@Mock
	VoteService voteService;
	
	@Mock
	RestaurantService restaurantService;
	
	List<RestaurantData> restaurants = new ArrayList<RestaurantData>();
	
	/**
	 * 
	 */
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(restaurantController).build();
		MockitoAnnotations.initMocks(this);
		
		RestaurantData restaurantData1 = new RestaurantData();
		restaurantData1.setId(1);
		restaurantData1.setName("name 1");
		restaurantData1.setVotes(1);
		restaurantData1.setVotesPercent(50);
		
		RestaurantData restaurantData2 = new RestaurantData();
		restaurantData2.setId(2);
		restaurantData2.setName("name 2");
		restaurantData2.setVotes(1);
		restaurantData2.setVotesPercent(50);
		
		restaurants.add(restaurantData1);
		restaurants.add(restaurantData2);
	}
	
	@Test
	public void listAllRestaurantsTest() throws Exception{
		
		Mockito.when(restaurantService.listDatas()).thenReturn(restaurants);
		
		mockMvc.perform(get("/api/restaurant/list")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$[0].name", is("name 1")));
	}
	
	@Test
	public void voteTest() throws Exception{
		Restaurant restaurant = new Restaurant("Test");
		restaurant.setId(1);
		
		Mockito.when(restaurantService.get(1)).thenReturn(restaurant);
		Mockito.when(restaurantService.get(2)).thenReturn(null);
		
		mockMvc.perform(put("/api/restaurant/vote/1")).andExpect(status().isOk());
		
		mockMvc.perform(put("/api/restaurant/vote/2")).andExpect(status().isInternalServerError());
	}
	
	@Test
	public void resultTest() throws Exception{
		
		Mockito.when(voteService.getResultListData()).thenReturn(restaurants);
		
		mockMvc.perform(get("/api/restaurant/result")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$[0].votesPercent", is(50)));
		
	}
	
	@Test
	public void resultEmptyTest() throws Exception{
		
		Mockito.when(voteService.getResultListData()).thenReturn(new ArrayList<RestaurantData>());
		
		mockMvc.perform(get("/api/restaurant/result")).andExpect(status().isNoContent())
		.andExpect(content().contentType("application/json;charset=UTF-8"));
		
	}
}
