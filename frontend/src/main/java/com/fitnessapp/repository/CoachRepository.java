package com.fitnessapp.repository;

import com.fitnessapp.model.Coach;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
	
	List<Coach> findAllCoaches(); 
	Optional<Coach> findById(long id); 
}
