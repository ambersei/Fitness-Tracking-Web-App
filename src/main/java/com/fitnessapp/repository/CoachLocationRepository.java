package com.fitnessapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitnessapp.model.CoachLocation;

public interface CoachLocationRepository extends JpaRepository<CoachLocation, Long> {
	
	List<CoachLocation> findAllByLocationId(Long id); 
}
