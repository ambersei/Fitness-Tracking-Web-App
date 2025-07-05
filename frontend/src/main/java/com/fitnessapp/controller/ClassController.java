package com.fitnessapp.controller;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fitnessapp.model.Class;
import com.fitnessapp.service.ClassService;

@RestController
@RequestMapping("/api/classes")
@CrossOrigin(origins ="*")
public class ClassController {
	
	private final ClassService classService; 
	
	public ClassController(ClassService classService) {
		this.classService = classService; 
	}
	
	@GetMapping
	public List<Class> getAllClasses(){
		return classService.getAllClasses(); 
	}

	@PostMapping
	public Class saveClass(@RequestBody Class groupClass) {
		return classService.saveClass(groupClass); 
	}
}
