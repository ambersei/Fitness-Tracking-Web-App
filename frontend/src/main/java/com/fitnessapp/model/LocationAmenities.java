package com.fitnessapp.model;
import jakarta.persistence.*;
import lombok.*; 

@Entity
@Table(name = "location_amenities")
@Data
@NoArgsConstructor 
@AllArgsConstructor 

public class LocationAmenities {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location; 
	
	@ManyToOne
	@JoinColumn(name="amenities_id")
	private Amenity amenity; 
	
	
	public Location getLocation() {
	    return location;
	}

	public Amenity getAmenity() {
	    return amenity;
	}

	

}
