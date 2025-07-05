package com.fitnessapp.model;

import jakarta.persistence.*;

import lombok.*; 

@Entity
@Table(name = "amenities")
@Data
@NoArgsConstructor 
@AllArgsConstructor
public class Amenity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String name; 
	private String description; 
	
	
}
