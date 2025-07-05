package com.fitnessapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitnessapp.model.Coach;
import com.fitnessapp.model.CoachClient;

public interface CoachClientRepository extends JpaRepository<CoachClient, Long>{
	
	List<Coach> findCoachByClient(Long client_id); 
}
