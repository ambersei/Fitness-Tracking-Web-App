package com.fitnessapp.repository;

import com.fitnessapp.model.Client;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ClientRepository extends JpaRepository<Client, Long>  {
	
	Optional<Client> findByEmailAndPassword(String email, String password);
	Optional<Client> findByEmail(String email); 
	
	@Query("SELECT c FROM Client c WHERE c.id = :id")
	Optional<Client> findClientById(@Param("id") Long id); 
	


}
