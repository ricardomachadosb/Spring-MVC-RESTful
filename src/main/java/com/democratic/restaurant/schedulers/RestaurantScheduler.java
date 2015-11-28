package com.democratic.restaurant.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.democratic.restaurant.service.VoteService;


/**
 * @author Ricardo Machado
 *
 */
@EnableScheduling
@Component
public class RestaurantScheduler {
	
    @Autowired
    private ApplicationContext ctx;
    
    @Autowired
    private VoteService voteService;

    @Scheduled(cron="0 0 6 * * ?")
    public void startNewVote(){
    	voteService.startNewVote();
    }
    
    @Scheduled(cron="0 0 11 * * ?")
    public void finishVoting(){
    	voteService.finishVoting();
    }
}
