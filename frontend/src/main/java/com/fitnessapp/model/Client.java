package com.fitnessapp.model;

import jakarta.persistence.*;
import lombok.*; 

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor 
@AllArgsConstructor
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String name; 
	private String email;
	private String phone;
	private String password; 
	
	
	


}
