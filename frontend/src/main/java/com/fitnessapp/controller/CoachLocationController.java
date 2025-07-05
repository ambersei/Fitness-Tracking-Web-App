package com.fitnessapp.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.fitnessapp.model.CoachLocation;
import com.fitnessapp.service.CoachLocationService;

public class CoachLocationController {

	private final CoachLocationService coachLocationService; 
	
	public CoachLocationController(CoachLocationService coachLocationService) {
		this.coachLocationService = coachLocationService; 
	}
	
	@GetMapping
	public List<CoachLocation> getAllCoachLocations(){
		return coachLocationService.getAllCoachLocations(); 
	}
}
