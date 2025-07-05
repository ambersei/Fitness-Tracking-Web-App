package com.fitnessapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fitnessapp.model.Coach;
import com.fitnessapp.service.CoachService;

@RestController
@RequestMapping("/api/coaches")
@CrossOrigin(origins = "*")
public class CoachController {
	
private final CoachService coachService; 
	
	public CoachController(CoachService coachService) {
		this.coachService = coachService; 
	}
	
	@GetMapping
	public List<Coach> getAllCoaches(){
		return coachService.getAllCoaches(); 
	}

	
	@PostMapping 
	public Coach saveCoach(@RequestBody Coach coach) {
		return coachService.saveCoach(coach); 
	}
	
	

}
