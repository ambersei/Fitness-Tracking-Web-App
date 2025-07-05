package com.fitnessapp.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fitnessapp.model.Review;
import com.fitnessapp.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {
	
	private final ReviewService reviewService; 
	
	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService; 
	}
	
	@GetMapping
	public List<Review> getAllReviews(){
		return reviewService.getAllReviews(); 
	}

	@PostMapping
	public Review saveClass(@RequestBody Review review) {
		return reviewService.saveReview(review); 
	}
}
