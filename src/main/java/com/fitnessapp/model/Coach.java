package com.fitnessapp.model;

import jakarta.persistence.*;

import lombok.*; 

@Entity
@Table(name = "coaches")
@Data
@NoArgsConstructor 
@AllArgsConstructor

public class Coach {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NonNull
	private String name; 
	
	private int level; 
	private Double rating; 

}
