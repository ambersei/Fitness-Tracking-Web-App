package com.fitnessapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitnessapp.model.Amenity;
import com.fitnessapp.model.Coach;
import com.fitnessapp.model.Location;
import com.fitnessapp.service.LocationAmenityService;
import com.fitnessapp.service.LocationService;

@RestController
@RequestMapping("/api/locations")
@CrossOrigin(origins ="*")
public class LocationController {
	
	private final LocationService locationService; 
	
	public LocationController(LocationService locationService, LocationAmenityService locationAmenityService) {
		this.locationService = locationService;
	}
	
	
	@GetMapping
	public List<Location> getAllLocations(){
		return locationService.getAllLocations(); 
	}
	
	@GetMapping("/{id}")
	public Location getOneLocation(@PathVariable Long id){
		return locationService.getOneLocations(id); 
	}
	
	@GetMapping("/{id}/amenities")
	public List<Amenity> getAmenitiesByLocation(@PathVariable Long id){
		return locationService.getAmenitiesForLocation(id); 
	}
	
	@GetMapping("/{id}/coaches")
	public List<Coach> getCoachesByLocation(@PathVariable Long id){
		return locationService.getCoachesForLocation(id); 
	}
	
	@PostMapping 
	public Location createLocation(@RequestBody Location location) {
		return locationService.createLocation(location); 
		
	}


}
