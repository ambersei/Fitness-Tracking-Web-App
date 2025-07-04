package com.fitnessapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.fitnessapp.model.Class;
import com.fitnessapp.repository.ClassRepository;

@Service
public class ClassService {
	
	private final ClassRepository classRepostiroty; 
	
	public ClassService(ClassRepository classRepostiroty) {
		this.classRepostiroty = classRepostiroty; 
	}
	
	public List<Class> getAllClasses(){
		return classRepostiroty.findAll(); 
	}
	
	public Class saveClass(Class groupClass) {
		return classRepostiroty.save(groupClass); 
	}
	

	

}
