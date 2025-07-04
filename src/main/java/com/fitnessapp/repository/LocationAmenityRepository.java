package com.fitnessapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitnessapp.model.Amenity;
import com.fitnessapp.model.LocationAmenities;

public interface LocationAmenityRepository extends JpaRepository<LocationAmenities, Long> {
	
	Optional<Amenity> getAllByLocationId(Long id); 
	List<LocationAmenities> findAllByLocationId(Long locationId); 
}
