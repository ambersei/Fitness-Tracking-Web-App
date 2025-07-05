package com.fitnessapp.model;
import jakarta.persistence.*;
import lombok.*; 

@Entity
@Table(name = "coach_client")
@Data
@NoArgsConstructor 
@AllArgsConstructor 

public class CoachClient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@ManyToOne
	@JoinColumn(name="coach_id")
	private Coach coach; 
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client; 
	

}
