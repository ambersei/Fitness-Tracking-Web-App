package com.fitnessapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fitnessapp.model.Client;
import com.fitnessapp.model.ClientLocation;
import com.fitnessapp.model.Location;
import com.fitnessapp.service.ClientLocationService;
import com.fitnessapp.service.ClientService;

@RestController
@RequestMapping("/api/client_location")
@CrossOrigin(origins ="*")
public class ClientLocationController {
	
	private final ClientLocationService clientLocationService; 
	private final ClientService clientService; 
	
	public ClientLocationController(ClientLocationService clientLocationService, 
								ClientService clientService) {
		this.clientLocationService = clientLocationService; 
		this.clientService = clientService; 
	}
	
	@GetMapping
	public List<ClientLocation> getAllClientLocations(){
		return clientLocationService.getAllClientLocations(); 
	}
	
	@GetMapping("/home")
	public ClientLocation getHomeLocation(@RequestParam Long clientId){
		Client client = clientService.getClientById(clientId); 
		if(client == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found" + clientId); 
		}
		return clientLocationService.getClientHomeLocation(client); 
		
	}
	
	
	@GetMapping("/visited")
	public List<ClientLocation> getVisitedLocations(@RequestParam Long clientId){
		Client client = clientService.getClientById(clientId); 
		if(client == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found" + clientId); 
		}
	
		 return clientLocationService.getVisitedClientLocation(client);  
		  
	}
	
	
	@GetMapping("/unvisited")
	public List<Location> getUnvisitedLocation(@RequestParam Long clientId) {
		Client client = clientService.getClientById(clientId); 
		if(client == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found" + clientId); 
		}
		return clientLocationService.getUnvisitedClientLocation(client); 
	}

}
