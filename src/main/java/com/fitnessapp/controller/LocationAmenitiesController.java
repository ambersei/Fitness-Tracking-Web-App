package com.fitnessapp.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.fitnessapp.model.LocationAmenities;
import com.fitnessapp.service.LocationAmenityService;

public class LocationAmenitiesController {
		
	private final LocationAmenityService locationAmenityService; 
	
	public LocationAmenitiesController(LocationAmenityService locationAmenityService) {
		this.locationAmenityService = locationAmenityService; 
	}
	
	@GetMapping
	public List<LocationAmenities> getAllLocationAmenities(){
		return locationAmenityService.getAllLocationAmenities(); 
	}
}
