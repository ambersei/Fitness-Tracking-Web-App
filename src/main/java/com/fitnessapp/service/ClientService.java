package com.fitnessapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.fitnessapp.model.Client;
import com.fitnessapp.repository.ClientRepository;

@Service
public class ClientService {
	
	private final ClientRepository clientRepository; 
	
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository; 
	}
	
	public List<Client> getAllClients(){
		return clientRepository.findAll(); 
	}
	
	public Client getClientById(Long id) {
	    return clientRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Client not found with id: " + id));
	}
	
//	public Client saveClient(Client client) {
//		return clientRepository.save(client); 
//	}
//	
	// test for user id and password 
	public Optional<Client> signIn(String email, String password) {
	    return clientRepository.findByEmailAndPassword(email, password);
	}
	
	public Client createClient(Client client) {
		if(clientRepository.findByEmail(client.getEmail()).isPresent()) {
			throw new IllegalArgumentException("Email already in use."); 
			
		}
		return clientRepository.save(client); 
	}

}
