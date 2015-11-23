package com.democratic.restaurant.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class RestaurantScheduler {
    @Autowired
    private ApplicationContext ctx;

    @Scheduled(fixedRate=5000)
    public void startNew(){
        System.out.println("--------------------");
    }
}
