package com.fitnessapp.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fitnessapp.model.Amenity;
import com.fitnessapp.repository.AmenityRepository;

@Repository 
public class AmenityService {
	
	private final AmenityRepository amenityRepository; 
	
	public AmenityService(AmenityRepository amenityRepository) {
		this.amenityRepository = amenityRepository; 
	}
	
	public List<Amenity> getAllAmenity(){
		return amenityRepository.findAll(); 
	}
	
	public Amenity getOneAmenity(Long id) {
		return amenityRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Amenity not found with id: " + id));
	}
	
	public Amenity saveAmenity(Amenity amenity) {
		return amenityRepository.save(amenity); 
	}
}
