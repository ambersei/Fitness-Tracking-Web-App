package com.fitnessapp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Repository;
import com.fitnessapp.model.Client;
import com.fitnessapp.model.ClientLocation;
import com.fitnessapp.model.Location;
import com.fitnessapp.repository.ClientLocationRepository;
import com.fitnessapp.repository.LocationRepository;

@Repository
public class ClientLocationService {
	
	private final ClientLocationRepository clientLocationRepository;
	private final LocationRepository locationRepository; 
	
	public ClientLocationService(ClientLocationRepository clientLocationRepository, LocationRepository locationRepository){
		this.clientLocationRepository = clientLocationRepository; 
		this.locationRepository = locationRepository; 
	}
	
	// get All 
	public List<ClientLocation> getAllClientLocations(){
		return clientLocationRepository.findAll(); 
	}
	
	// get all by client id 
	public List<ClientLocation> getClientLocations(Client client){
		
		List<ClientLocation> all = clientLocationRepository.findByClientId(client.getId());
	    all.sort((a, b) -> Boolean.compare(!a.isHomeLocation(), !b.isHomeLocation()));
	   
	    return all;  
 
	}
	
	public ClientLocation getClientHomeLocation(Client client){
		
		List<ClientLocation> sorted = getClientLocations(client); 
		
		return sorted.isEmpty()? null : sorted.get(0); 
	}
	
	//get the remaining locations 
	public List<ClientLocation> getVisitedClientLocation(Client client){
		
		List<ClientLocation> sorted = getClientLocations(client); 
		if(!sorted.isEmpty()) {
			sorted.remove(0);  // remove home location 
		}
		
		sorted.sort((a,b)-> Integer.compare(b.getVisitCount(), a.getVisitCount()));
		
		return sorted; 
	}

	// get unvisited location 
	public List<Location> getUnvisitedClientLocation(Client client){
		
		List<ClientLocation> visited = getClientLocations(client);
		
		Set<Long> visitedLocIds = new HashSet<>(); 
		
		for(ClientLocation item: visited) {
			visitedLocIds.add(item.getLocation().getId()); 
		}
		
		// call locationsRepository get all location 
		
		List<Location> allLocations = locationRepository.findAll(); 
		
		List<Location> unvisited = new ArrayList<>(); 
		
		// remove the location by location id that already visited
		
		for(Location loc: allLocations) {
			if(!visitedLocIds.contains(loc.getId())){
				unvisited.add(loc); 
			}
		}
		
		return unvisited; 
		
	}

}
