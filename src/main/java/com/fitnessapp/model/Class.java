package com.fitnessapp.model;

import jakarta.persistence.*;

import lombok.*; 

@Entity
@Table(name = "classes")
@Data
@NoArgsConstructor 
@AllArgsConstructor

public class Class {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String name; 
	private Double price; 
	private String room; 
	
	@ManyToOne
    @JoinColumn(name = "location_id") // Maps the foreign key column in the database
    private Location location;
	
}
