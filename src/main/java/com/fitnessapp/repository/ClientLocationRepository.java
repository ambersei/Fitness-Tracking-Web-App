package com.fitnessapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fitnessapp.model.ClientLocation;

public interface ClientLocationRepository extends JpaRepository<ClientLocation, Long> {
		
	List<ClientLocation> findByClientId(Long client_id); 
}
