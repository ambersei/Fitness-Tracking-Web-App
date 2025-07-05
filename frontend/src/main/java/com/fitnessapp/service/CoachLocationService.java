package com.fitnessapp.service;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.fitnessapp.model.CoachLocation;
import com.fitnessapp.repository.CoachLocationRepository;

@Repository
public class CoachLocationService {
	
	private final CoachLocationRepository coachLocationRepository; 
	
	public CoachLocationService (CoachLocationRepository coachLocationRepository) {
		this.coachLocationRepository= coachLocationRepository; 
	}

	public List<CoachLocation> getAllCoachLocations(){
		return coachLocationRepository.findAll(); 
	}
}
