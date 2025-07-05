package com.fitnessapp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.fitnessapp.model.Client;
import com.fitnessapp.model.Coach;
import com.fitnessapp.model.CoachClient;
import com.fitnessapp.repository.CoachClientRepository;
import com.fitnessapp.repository.CoachRepository;

@Repository
public class CoachClientService {
	
	private final CoachClientRepository coachClientRepository; 
	private final CoachRepository coachRepository; 
	
	public CoachClientService(CoachClientRepository coachClientRepository, CoachRepository coachRepository ){
		this.coachClientRepository = coachClientRepository; 
		this.coachRepository = coachRepository; 
	}
	
	// get ALL
	public List<CoachClient> getAllCoachClient(){
		return coachClientRepository.findAll(); 
	}
	
	// get all coach with given client_id
	public List<Coach> getCoachesforClient(Client client){
		
		List<Coach> myCoaches = coachClientRepository.findCoachByClient(client.getId()); 
	
		return myCoaches; 
	}
	
	// get remaining coaches list 
	public List<Coach> getOtherCoachesforClient(Client client){
		
		List<Coach> clientHomeCoach = getCoachesforClient(client); 
		Set<Long> myCoachIds = new HashSet<>(); 
		
		for(Coach item: clientHomeCoach) {
			myCoachIds.add(item.getId()); 
		}
		
		List<Coach> allCoaches = coachRepository.findAllCoaches();  
		List<Coach> otherCoaches = new ArrayList<>(); 
		
		for (Coach coach: allCoaches) {
			if(!myCoachIds.contains(coach.getId())) {
				otherCoaches.add(coach); 
			}
		}
		
		return otherCoaches; 
	}
	
	
}
