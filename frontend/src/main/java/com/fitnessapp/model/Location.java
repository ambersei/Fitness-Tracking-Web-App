package com.fitnessapp.model;

import jakarta.persistence.*;

import lombok.*; 

@Entity
@Table(name = "locations")
@Data
@NoArgsConstructor 
@AllArgsConstructor

public class Location {
	
	@Id  // set the id as primary key 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NonNull
	private String name; 
	@NonNull
	private String address; 
	@NonNull
	private String telephone; 
	@NonNull
	private String email;

	
}
