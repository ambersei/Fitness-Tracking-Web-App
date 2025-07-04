package com.fitnessapp.service;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.fitnessapp.model.LocationAmenities;
import com.fitnessapp.repository.AmenityRepository;
import com.fitnessapp.repository.LocationAmenityRepository;

@Repository
public class LocationAmenityService {
	
	private final LocationAmenityRepository locationAmenityRepository; 
	
	public LocationAmenityService(LocationAmenityRepository locationAmenityRepository,
			AmenityRepository amenityRepository) {
		this.locationAmenityRepository = locationAmenityRepository; 

	}
	

	public List<LocationAmenities> getAllLocationAmenities(){
		return locationAmenityRepository.findAll(); 
	}
	

}
