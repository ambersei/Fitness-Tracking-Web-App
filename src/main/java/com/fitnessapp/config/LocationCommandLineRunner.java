package com.fitnessapp.config;

import com.fitnessapp.repository.LocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LocationCommandLineRunner implements CommandLineRunner {
	
	private final LocationRepository locationRepository;

    public LocationCommandLineRunner(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Sample data
//        Location gym1 = new Location(null, "Downtown Gym", "123 King St", "416-111-1111", "contact@downtown.ca");
//        Location gym2 = new Location(null, "West End Fitness", "456 Queen St", "416-222-2222", "info@westend.ca");

//        locationRepository.save(gym1);
//        locationRepository.save(gym2);

        // Confirm save
        System.out.println("All gyms:");
        locationRepository.findAll().forEach(System.out::println);
    }
}
