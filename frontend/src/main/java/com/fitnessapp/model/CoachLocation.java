package com.fitnessapp.model;
import jakarta.persistence.*;
import lombok.*; 

@Entity
@Table(name = "coach_location")
@Data
@NoArgsConstructor 
@AllArgsConstructor 

public class CoachLocation {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@ManyToOne
	@JoinColumn(name="coach_id")
	private Coach coach; 
	
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location; 
	

}
