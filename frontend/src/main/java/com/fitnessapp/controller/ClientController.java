package com.fitnessapp.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fitnessapp.model.Client;
import com.fitnessapp.service.ClientService;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "*")
public class ClientController {
	
	private final ClientService clientService; 
	
	public ClientController(ClientService clientService) {
		this.clientService = clientService; 
	}
	
	@GetMapping
	public List<Client> getAllClients(){
		System.out.println("GET /api/clients hit!");// debugging print 
		return clientService.getAllClients(); 
	}
	
	@PostMapping 
	public Client createClient(@RequestBody Client client) {
		return clientService.createClient(client); 
	}
	
	@PostMapping("/signin")
	public ResponseEntity<Client> signIn(@RequestBody Map<String, String> payload) {
	    String email = payload.get("email");
	    String password = payload.get("password");

	    Optional<Client> client = clientService.signIn(email, password);
	    
	    System.out.println("Attempting login for: " + email);// temp print out the record 
	    System.out.println("Client found: " + client.isPresent()); // temp print out the record 


	    return client.map(ResponseEntity::ok)
	                 .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

}
