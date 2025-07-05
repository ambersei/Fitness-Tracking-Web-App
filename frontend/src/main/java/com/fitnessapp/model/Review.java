package com.fitnessapp.model;
import java.util.Date;// check which one to use 

import jakarta.persistence.*;

import lombok.*; 

@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor 
@AllArgsConstructor
public class Review {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NonNull
	private Date date; 
	private int communication; 
	private int enthusiasm; 
	private int punctuality; 
	
	private String comment; 
	
	@ManyToOne
    @JoinColumn(name = "client_id") 
    private Client client;
	
	@ManyToOne
    @JoinColumn(name = "coach_id") 
    private Coach coach;
}
