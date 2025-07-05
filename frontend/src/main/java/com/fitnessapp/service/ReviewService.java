package com.fitnessapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fitnessapp.model.Coach;
import com.fitnessapp.model.Review;
import com.fitnessapp.repository.CoachRepository;
import com.fitnessapp.repository.ReviewRepository;

@Service
public class ReviewService {
	
	private final ReviewRepository reviewRepository;
	private final CoachRepository coachRepository; 
	
	public ReviewService(ReviewRepository reviewRepository, CoachRepository coachRepository) {
        this.reviewRepository = reviewRepository;
        this.coachRepository = coachRepository;
    }
	
	public List<Review> getAllReviews(){
		return reviewRepository.findAll(); 
	}

	public Review saveReview(Review review) {
		return reviewRepository.save(review); 
	}
	
	public List<Review> getAllReviewsByCoachId(Coach coach){
		return reviewRepository.findAllByCoachId(coach.getId()); 
	}
	
	public double calculateRating(List<Review> reviewList) {
		
		if (reviewList == null ||reviewList.isEmpty()) return 0.0;
		
		int totalPoints = 0; 
		int totalRating = 0; 
		
		for(Review review: reviewList) {
			totalPoints += review.getCommunication() + review.getEnthusiasm() + review.getPunctuality(); 
			totalRating += 3; 
		}
		
		return (double) totalPoints/totalRating; 
	}
	
	
	public Review createReview(Review review) {
		
		Review saved = reviewRepository.save(review); 
		
		List<Review> coachReviews = getAllReviewsByCoachId(review.getCoach()); 
		double averageRating = calculateRating(coachReviews); 
		
		Coach coach = review.getCoach(); 
		coach.setRating(averageRating);
		coachRepository.save(coach); 
		
		return saved; 
	}
	
}
