package com.fitnessapp.repository;

import com.fitnessapp.model.Location;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long>{
	
	Optional<Location> findByAddress(String address); 
	Optional<Location> findById(long id); 
}
