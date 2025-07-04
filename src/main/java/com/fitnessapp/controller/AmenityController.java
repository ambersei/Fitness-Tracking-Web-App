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
import com.fitnessapp.service.AmenityService;

@RestController
@RequestMapping("/api/amenities")
@CrossOrigin(origins ="*")
public class AmenityController {
	
	private final AmenityService amenityService; 
	
	public AmenityController(AmenityService amenityService) {
		this.amenityService = amenityService; 
	}
	
	@GetMapping
	public List<Amenity> getAllAmenities(){
		return amenityService.getAllAmenity(); 
	}
	
	@GetMapping("/{id}")
	public Amenity getOneAmenity(@PathVariable Long id) {
		return amenityService.getOneAmenity(id); 
	}
	
	@PostMapping 
	public Amenity saveAmenity(@RequestBody Amenity amenity) {
		return amenityService.saveAmenity(amenity); 
	}

}
