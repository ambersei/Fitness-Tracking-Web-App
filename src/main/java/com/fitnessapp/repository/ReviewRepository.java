package com.fitnessapp.repository;


import com.fitnessapp.model.Review;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	List<Review> findAllByCoachId(Long coach_id);


}
