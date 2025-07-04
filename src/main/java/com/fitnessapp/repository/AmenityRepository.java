package com.fitnessapp.repository;

import com.fitnessapp.model.Amenity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenityRepository extends JpaRepository<Amenity, Long> {
	
	Optional<Amenity> findById(long id); 

}
