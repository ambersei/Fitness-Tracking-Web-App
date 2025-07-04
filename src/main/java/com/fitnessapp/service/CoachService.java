package com.fitnessapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.fitnessapp.model.Coach;
import com.fitnessapp.model.Review;
import com.fitnessapp.repository.CoachRepository;
import com.fitnessapp.repository.ReviewRepository;

@Service
public class CoachService {
	
	private final CoachRepository coachRepository; 
	private final ReviewRepository reviewRepository; 
	private final ReviewService reviewService; 
	
	public CoachService(CoachRepository coachRepository, ReviewRepository reviewRepository, ReviewService reviewService) {
        this.coachRepository = coachRepository;
        this.reviewRepository = reviewRepository;
        this.reviewService = reviewService;
    }
	
	public List<Coach> getAllCoaches(){
		return coachRepository.findAll(); 
	}
	
	public Coach getOneCoachById(Long id) {
		return coachRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Coach not found with id:" + id)); 
	}
	
	public Coach saveCoach(Coach coach) {
		return coachRepository.save(coach); 
	}
	
	// return list of coaches for one client 
	
	public void calculateAllCoachRatings() {
		
		List<Coach> coachList = coachRepository.findAll();  
		
		for (Coach coach: coachList) {
			List<Review> reviews = reviewRepository.findAllByCoachId(coach.getId());; 
			double coachRating = reviewService.calculateRating(reviews); 
			coach.setRating(coachRating);
		}
		coachRepository.saveAll(coachList); 
	}
	
	

}
