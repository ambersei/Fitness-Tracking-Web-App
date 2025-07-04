package com.fitnessapp.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*; 

@Entity
@Table(name = "client_location")
@Data
@NoArgsConstructor 
@AllArgsConstructor 

public class ClientLocation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	 
	@ManyToOne
    @JoinColumn(name="client_id")
	private Client client; 
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="location_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Location location; 
	
	private boolean homeLocation; 
	
	private int visitCount; 
	
}
