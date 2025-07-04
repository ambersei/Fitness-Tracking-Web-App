package com.fitnessapp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.fitnessapp.repository.ClientRepository;


@Component
public class ClientsCommandLineRunner implements CommandLineRunner {
	
	private final ClientRepository clientRepository;

    public ClientsCommandLineRunner(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("All clients:");
        clientRepository.findAll().forEach(System.out::println);
    }

}
