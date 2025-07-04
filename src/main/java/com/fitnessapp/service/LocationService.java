package com.fitnessapp.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fitnessapp.model.Amenity;
import com.fitnessapp.model.Coach;
import com.fitnessapp.model.CoachLocation;
import com.fitnessapp.model.Location;
import com.fitnessapp.model.LocationAmenities;
import com.fitnessapp.repository.CoachLocationRepository;
import com.fitnessapp.repository.LocationAmenityRepository;
import com.fitnessapp.repository.LocationRepository;

@Service
public class LocationService {
	
	private final LocationRepository locationRepository;  
	private final LocationAmenityRepository locationAmenityRepository;
	private final CoachLocationRepository coachLocationRepository;
	
	public LocationService(LocationRepository locationRepository, LocationAmenityRepository locationAmenityRepository, 
			CoachLocationRepository coachLocationRepository) {
        this.locationRepository = locationRepository;
		this.locationAmenityRepository = locationAmenityRepository; 
		this.coachLocationRepository = coachLocationRepository; 
    }
	
	public List<Location> getAllLocations(){
		return locationRepository.findAll(); 
	}
	
	public Location getOneLocations(Long id){
		return locationRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Location not found with id: " + id));  
	}
 
	public Location createLocation(Location location) {
		
		if(locationRepository.findByAddress(location.getAddress()).isPresent()) {
			throw new IllegalArgumentException("Address already in use"); 
		}
		
		return locationRepository.save(location); 
	}
	
	public List<Amenity> getAmenitiesForLocation(Long locationId) {
		
		List<LocationAmenities> links = locationAmenityRepository.findAllByLocationId(locationId);
		List<Amenity> amenities = links.stream()
		        .map(LocationAmenities::getAmenity)
		        .collect(Collectors.toList());
		
		return amenities; 
	}
	
	public List<Coach> getCoachesForLocation(Long locationId){
		List<CoachLocation> links = coachLocationRepository.findAllByLocationId(locationId); 
		List<Coach> coaches = links.stream()
				.map(CoachLocation :: getCoach)
				.collect(Collectors.toList()); 
		return coaches; 
	}

}
