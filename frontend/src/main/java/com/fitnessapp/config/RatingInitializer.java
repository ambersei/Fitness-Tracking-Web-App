package com.fitnessapp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.fitnessapp.service.CoachService;

@Component
public class RatingInitializer implements CommandLineRunner {
	
	private final CoachService coachService; 
	
	public RatingInitializer(CoachService coachService) {
		this.coachService = coachService; 
	}
	
	 @Override
	    public void run(String... args) throws Exception {
		 coachService.calculateAllCoachRatings();
		 System.out.println("Coach rating is updated"); 
		 
	 }
}
