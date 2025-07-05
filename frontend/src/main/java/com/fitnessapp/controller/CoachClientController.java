package com.fitnessapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.fitnessapp.model.Client;
import com.fitnessapp.model.Coach;
import com.fitnessapp.model.CoachClient;
import com.fitnessapp.repository.CoachClientRepository;
import com.fitnessapp.service.ClientService;
import com.fitnessapp.service.CoachClientService;

public class CoachClientController {
	
	private final CoachClientService coachClientService; 
	private final ClientService clientService; 
	
	public CoachClientController(CoachClientService coachClientService, ClientService clientService) {
		this.coachClientService = coachClientService; 
		this.clientService = clientService; 
	}
	
	@GetMapping
	public List<CoachClient> getAllCoachClients(){
		return coachClientService.getAllCoachClient(); 
	}
	
	@GetMapping("/myCoach")
	public List<Coach> getClientMyCoaches(@RequestParam Long clientId){
		Client client =  clientService.getClientById(clientId); 
		
		if(client == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "client not found "+ clientId); 
		}
		
		return coachClientService.getCoachesforClient(client); // better to return coach here as we are displaying the coach rating 
		
	}
	
}
